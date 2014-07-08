package com.htmlism.spawningpool

class Solver {
  def solve[T](seed: Traversable[T]): Set[T] =
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      seed.toSet
}
