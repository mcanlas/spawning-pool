package com.htmlism.spawningpool

class IndexProvider(indices: Traversable[Int]) extends DeterministicProvider[Int](indices) with RandomIndexProvider {
  def this(indices: Int*) = this(indices)

  def randomIndex(size: Int) = nextElement
}
