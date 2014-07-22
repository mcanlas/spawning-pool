package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object Solver {
  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexGenerator) = population(rig.randomIndex(population.size))
}

class Solver[A, B](fitnessFunction: A => B, populationSize: Int = 50, islandCount: Int = 4)(implicit order: Ordering[B], rig: RandomIndexGenerator) {
  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve(implicit src: Generator[A]): Future[Set[A]] = evolveFrom { Vector.fill(populationSize)(src.generate) }

  def solve(seed: Traversable[A]): Future[Set[A]] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else evolveFrom { seed.toVector }

  def evolveFrom(seeding: => Vector[A]) = future {
    val islands = generateIslands(seeding)

    val evolvedIslands = islands

    fittestSolutions(evolvedIslands)
  }

  def solveNow(implicit src: Generator[A]): Set[A] = awaitResult(solve(src))

  def solveNow(seed: Traversable[A]): Set[A] = awaitResult(solve(seed))

  private def fittestMember(population: Traversable[A]): Set[A] = ??? // reduces a population into a set

  private def mutate(chromosome: A): A = ???

  private def crossover(a: A, b: A): A = ???

  private def sampleChromosome(chromosomes: Vector[A]): Vector[A] = ??? // consumes rig

  private def evolvePopulation(chromosomes: Vector[A]): Vector[A] = ??? // recursive

  private def fittestSolutions(islands: Traversable[Vector[A]]): Set[A] = {
    // TODO needs evolution/selection
    islands.fold(Vector.empty)((acc, pop) => acc ++ pop).toSet
  }

  private def generateIslands(f: => Vector[A]) = Traversable.fill(islandCount)(f)

  private def awaitResult[T](future: Future[T]) = Await.result(future, 0 nanos)
}
