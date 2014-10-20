package com.htmlism.spawningpool

import com.htmlism.spawningpool.combinatorics.ChromosomeGenerator

class ChromosomeProvider[A](chromosomes: Traversable[A]) extends DeterministicGenerator[A](chromosomes) with ChromosomeGenerator[A] {
  def this(chromosomes: A*) = this(chromosomes)

  def generateChromosome = nextElement
}
