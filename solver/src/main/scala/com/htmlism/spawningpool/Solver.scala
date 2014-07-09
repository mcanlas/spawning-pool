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

  def solve[T](implicit src: Generator[T]): Future[Set[T]] = {
    solve(Traversable.fill(populationSize)(src.generate))
  }

  def solve[T](seed: Traversable[T]): Future[Set[T]] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      future {
        seed.toSet
      }

  def solveNow[T](implicit src: Generator[T]): Set[T] = awaitResult(solve(src))

  def solveNow[T](seed: Traversable[T]): Set[T] = awaitResult(solve(seed))

  private def awaitResult[T](future: Future[T]) = Await.result(future, 0 nanos)
}
