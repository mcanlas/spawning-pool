package com.htmlism.spawningpool

class ChromosomeProvider[T](chromosomes: Traversable[T]) extends DeterministicGenerator[T](chromosomes) with Generator[T] {
  def this(chromosomes: T*) = this(chromosomes)

  def generate = nextElement
}