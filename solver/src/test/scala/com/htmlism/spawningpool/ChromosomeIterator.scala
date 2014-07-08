package com.htmlism.spawningpool

class ChromosomeIterator[T](chromosomes: Traversable[T]) extends DeterministicGenerator[T](chromosomes) with Generator[T] {
  def this(chromosomes: T*) = this(chromosomes)

  def generate = nextElement
}
