package com.htmlism.spawningpool

// TODO return futures
class Solver(populationSize: Int = 50)(implicit rig: RandomIndexGenerator) {
  def solve[T](implicit src: Generator[T]): Set[T] = solve(Traversable.fill(populationSize)(src.generate))

  def solve[T](seed: Traversable[T]): Set[T] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      seed.toSet
}
