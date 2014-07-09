package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

class Solver[A, B](fitnessFunction: A => B, populationSize: Int = 50, islandCount: Int = 4)(implicit rig: RandomIndexGenerator) {
  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve(implicit src: Generator[A]): Future[Set[A]] = future {
    val islands = generateIslands { Vector.fill(populationSize)(src.generate) }

    fittestSolutions(islands)
  }

  def solve(seed: Traversable[A]): Future[Set[A]] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      future {
        val islands = generateIslands { seed.toVector }

        fittestSolutions(islands)
      }

  def solveNow(implicit src: Generator[A]): Set[A] = awaitResult(solve(src))

  def solveNow(seed: Traversable[A]): Set[A] = awaitResult(solve(seed))

  private def fittestMember(population: Traversable[A]): Set[A] = ??? // reduces a population into a set

  private def mutate(chromosome: A): A = ???

  private def crossover(a: A, b: A): A = ???

  private def sampleChromosome(chromosomes: Vector[A]): Vector[A] = ??? // consumes rig

  private def evolvePopulation(chromosomes: Vector[A]): Vector[A] = ??? // recursive

  private def fittestSolutions(islands: Traversable[Vector[A]]): Set[A] = {
    islands.head.toSet // TODO test that islands > 1 affects results (using max)
  }

  private def generateIslands(f: => Vector[A]) = Traversable.fill(islandCount)(f)

  private def awaitResult[T](future: Future[T]) = Await.result(future, 0 nanos)
}
