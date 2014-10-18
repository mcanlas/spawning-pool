package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.annotation.tailrec

object Solver {
  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexGenerator): A = population(rig.randomIndex(population.size))

  @tailrec
  def evolvePopulation[A, B](implicit ctx: SolutionContext[A, B]): SolutionContext[A, B] =
    if (ctx.generations >= 10)
      ctx
    else {
      println(s"island ${ctx.id} generating children for generation ${ctx.generations}")
      val newPopulation = Vector.fill(ctx.population.size)(bearChild)

      evolvePopulation(ctx.increment(newPopulation))
    }

  def tournamentSelect[A, B](size: Int)(implicit ctx: SolutionContext[A, B]): A =
    if (size > 0)
      tournamentSelect(size, randomIndividual(ctx.population))
    else
      throw new IllegalArgumentException("tournament size must be at least 1")

  def tournamentSelect[A, B](size: Int, champion: A)(implicit ctx: SolutionContext[A, B]): A =
    if (size == 1)
      champion
    else {
      val challenger = randomIndividual(ctx.population)
      val compare = ctx.ordering.compare(ctx.fitness(champion), ctx.fitness(challenger))

      if (compare < 0)
        challenger
      else
        champion
    }

  def bearChild[A, B](implicit ctx: SolutionContext[A, B]): A = {
    val child = ctx.evolver.crossover(tournamentSelect(2), tournamentSelect(2))

    if ((new scala.util.Random).nextDouble < .01)
      ctx.evolver.mutate(child)
    else
      child
  }

  def awaitResult[A](future: Future[A]): A = Await.result(future, Duration.Inf)
}

class Solver[A, B](fitnessFunction: A => B, evolver: Evolver[A], populationSize: Int = 50, islandCount: Int = 4)(implicit ordering: Ordering[B], rig: RandomIndexGenerator) {
  import com.htmlism.spawningpool.Solver._

  type Population = Vector[A]
  type Solutions  = Set[A]

  private val fitness = memoize(fitnessFunction)

  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve(implicit src: ChromosomeGenerator[A]): Future[Solutions] = evolveFrom { Vector.fill(populationSize)(src.generateChromosome) }

  def solve(seed: Traversable[A]): Future[Solutions] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else evolveFrom { seed.toVector }

  private def evolveFrom(seeding: => Population) = Future {
    val islands = generateIslands(seeding)

    val evolvedIslands =
      islands.zipWithIndex.map { case (p, i) =>
        evolvePopulation(SolutionContext(i, fitness, evolver, p))
      }.map { ctx =>
      val byFitness = ctx.population.groupBy(ctx.fitness)

      byFitness(byFitness.keys.max)
    }

    evolvedIslands.foldLeft(Set.empty[A])((acc, sols) => acc ++ sols)
  }

  def solveNow(implicit src: ChromosomeGenerator[A]): Solutions = awaitResult(solve(src))

  def solveNow(seed: Traversable[A]): Solutions = awaitResult(solve(seed))

  private def generateIslands(f: => Population) = Iterable.fill(islandCount)(f)
}
