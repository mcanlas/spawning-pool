package com.htmlism.spawningpool

class Solver {
  def solve[T](seed: Traversable[T]): Set[T] = seed.toSet
}
