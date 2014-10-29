package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.duration._
import scala.annotation.tailrec

object Solver {
  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexProvider): A = population(rig.randomIndex(population.size))

  @tailrec
  def evolvePopulation[A, B](implicit ctx: SolutionContext[A, B]): SolutionContext[A, B] =
    if (ctx.generations >= 10)
      ctx
    else {
      println(s"island ${ctx.islandId} generating children for generation ${ctx.generations}")
      val newPopulation = Vector.fill(ctx.population.size)(bearChild)

      evolvePopulation(ctx.increment(newPopulation))
    }

  def tournamentSelect[A, B](size: Int)(implicit ctx: SolutionContext[A, B]): A =
    if (size > 0)
      tournamentSelect(size, randomIndividual(ctx.population))
    else
      throw new IllegalArgumentException("tournament size must be at least 1")

  @tailrec
  private def tournamentSelect[A, B](size: Int, champion: A)(implicit ctx: SolutionContext[A, B]): A =
    if (size == 1)
      champion
    else {
      val challenger = randomIndividual(ctx.population)
      val compare = ctx.ordering.compare(ctx.fitness(champion), ctx.fitness(challenger))

      val nextChampion = if (compare < 0) challenger else champion

      tournamentSelect(size - 1, nextChampion)
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

class Solver[A, B](fitness: A => B, evolver: Evolver[A], populationSize: Int = 50, islandCount: Int = 4)(implicit ordering: Ordering[B], rig: RandomIndexProvider) {
  import com.htmlism.spawningpool.Solver._

  type Population = Vector[A]
  type Solutions  = Set[A]

  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve(implicit src: ChromosomeGenerator[A], ec: ExecutionContext): Future[Solutions] = Future {
    evolveFrom { Vector.fill(populationSize)(src.generateChromosome) }
  }

  def solve(seed: Traversable[A])(implicit ec: ExecutionContext): Future[Solutions] = Future {
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else evolveFrom {
      seed.toVector
    }
  }

  def solveNow(implicit src: ChromosomeGenerator[A], ec: ExecutionContext): Solutions = awaitResult(solve)

  def solveNow(seed: Traversable[A])(implicit ec: ExecutionContext): Solutions = awaitResult(solve(seed))

  private def evolveFrom(seeding: => Population)(implicit ec: ExecutionContext) = {
    val islands = generateIslands(seeding)

    val evolvedIslands =
      islands.zipWithIndex.map { case (p, i) =>
        val calc = Future {
          evolvePopulation(SolutionContext(i, fitness, evolver, p))
        }

        calc.map { ctx =>
          val byFitness = ctx.population.groupBy(ctx.fitness)

          byFitness(byFitness.keys.max)
        }
      }

    evolvedIslands.foldLeft(Set.empty[A])((acc, sols) => acc ++ awaitResult(sols))
  }

  private def generateIslands(f: => Population) = Iterable.fill(islandCount)(f)
}
