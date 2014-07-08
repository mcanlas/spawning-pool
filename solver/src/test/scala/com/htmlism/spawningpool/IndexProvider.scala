package com.htmlism.spawningpool

class IndexProvider(indices: Traversable[Int]) extends DeterministicGenerator[Int](indices) with RandomIndexGenerator {
  def this(indices: Int*) = this(indices)

  def randomIndex(size: Int) = nextElement
}
