package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

class Solver(populationSize: Int = 50, islandCount: Int = 4)(implicit rig: RandomIndexGenerator) {
  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  if (islandCount < 1)
    throw new IllegalArgumentException("must have an island count of one or greater")

  def solve[T](implicit src: Generator[T]): Future[Set[T]] = future {
    val islands = generateIslands { Vector.fill(populationSize)(src.generate) }

    fittestSolutions(islands)
  }

  def solve[T](seed: Traversable[T]): Future[Set[T]] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      future {
        val islands = generateIslands { seed.toVector }

        fittestSolutions(islands)
      }

  def solveNow[T](implicit src: Generator[T]): Set[T] = awaitResult(solve(src))

  def solveNow[T](seed: Traversable[T]): Set[T] = awaitResult(solve(seed))

  private def fittestSolutions[T](islands: Traversable[Vector[T]]): Set[T] = {
    islands.head.toSet // TODO test that islands > 1 affects results (using max)
  }

  private def generateIslands[T](f: => Vector[T]) = Traversable.fill(islandCount)(f)

  private def awaitResult[T](future: Future[T]) = Await.result(future, 0 nanos)
}
