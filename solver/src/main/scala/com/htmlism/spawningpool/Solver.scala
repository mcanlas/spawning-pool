package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object Solver {
  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexGenerator): A = population(rig.randomIndex(population.size))

  def evolvePopulation[A](population: Vector[A]): Vector[A] = {
    population
  } // TODO hard count countdown termination to zero

  def sampleParent[A](population: Vector[A]): A = {
    val i = (new scala.util.Random).nextInt(population.size)
    population(i)
  }

  def awaitResult[A](future: Future[A]): A = Await.result(future, Duration.Inf)
}

class Solver[A, B](fitnessFunction: A => B, populationSize: Int = 50, islandCount: Int = 4)(implicit ordering: Ordering[B], rig: RandomIndexGenerator) {
  import com.htmlism.spawningpool.Solver._

  type Population = Vector[A]
  type Solutions  = Set[A]

  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  lazy val fitness = memoize(fitnessFunction)

  def solve(implicit src: ChromosomeGenerator[A]): Future[Solutions] = evolveFrom { Vector.fill(populationSize)(src.generateChromosome) }

  def solve(seed: Traversable[A]): Future[Solutions] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else evolveFrom { seed.toVector }

  def evolveFrom(seeding: => Population) = future {
    val islands = generateIslands(seeding)

    val evolvedIslands = islands.map { evolvePopulation }

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
