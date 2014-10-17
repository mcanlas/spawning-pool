package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Solver {
  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexGenerator): A = population(rig.randomIndex(population.size))

  def evolvePopulation[A, B](implicit ctx: SolutionContext[A, B]): Vector[A] = {
    ctx.population.toVector
  } // TODO hard count countdown termination to zero

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

  def bearChild[A <: Chromosome[A], B](implicit ctx: SolutionContext[A, B]): A = {
    val child = tournamentSelect(2) crossover tournamentSelect(2)

    child.mutate
  }

  def awaitResult[A](future: Future[A]): A = Await.result(future, Duration.Inf)
}

class Solver[A, B](fitnessFunction: A => B, evolver: Evolver[A], populationSize: Int = 50, islandCount: Int = 4)(implicit ordering: Ordering[B], rig: RandomIndexGenerator) {
  import com.htmlism.spawningpool.Solver._

  type Population = Vector[A]
  type Solutions  = Set[A]

  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve(implicit src: ChromosomeGenerator[A]): Future[Solutions] = evolveFrom { Vector.fill(populationSize)(src.generateChromosome) }

  def solve(seed: Traversable[A]): Future[Solutions] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else evolveFrom { seed.toVector }

  def evolveFrom(seeding: => Population) = Future {
    val islands = generateIslands(seeding)

    val evolvedIslands = islands.map { p => evolvePopulation(SolutionContext(fitnessFunction, evolver, p)) }

    fittestSolutions(evolvedIslands)
  }

  def solveNow(implicit src: ChromosomeGenerator[A]): Solutions = awaitResult(solve(src))

  def solveNow(seed: Traversable[A]): Solutions = awaitResult(solve(seed))

  private def fittestSolutions(islands: Traversable[Population]): Solutions = {
    // TODO needs evolution/selection
    islands.fold(Vector.empty)((acc, pop) => acc ++ pop).toSet
  }

  private def generateIslands(f: => Population) = Traversable.fill(islandCount)(f)
}
