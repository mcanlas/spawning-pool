package com.htmlism.spawningpool

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class Solver(populationSize: Int = 50)(implicit rig: RandomIndexGenerator) {
  if (populationSize < 1)
    throw new IllegalArgumentException("must have a population size of one or greater")

  def solve[T](implicit src: Generator[T]): Future[Set[T]] = solve(Traversable.fill(populationSize)(src.generate))

  def solve[T](seed: Traversable[T]): Future[Set[T]] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      future { seed.toSet }

  def solveNow[T](implicit src: Generator[T]): Set[T] = solveNow(Traversable.fill(populationSize)(src.generate))

  def solveNow[T](seed: Traversable[T]): Set[T] = Await.result(solve(seed), 0 nanos)
}
