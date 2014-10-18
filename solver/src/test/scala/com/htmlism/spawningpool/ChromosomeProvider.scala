package com.htmlism.spawningpool

import com.htmlism.spawningpool.combinatorics.ChromosomeGenerator

class ChromosomeProvider[T](chromosomes: Traversable[T]) extends DeterministicGenerator[T](chromosomes) with ChromosomeGenerator[T] {
  def this(chromosomes: T*) = this(chromosomes)

  def generateChromosome = nextElement
}
