package com.htmlism.spawningpool

class ChromosomeProvider[A](chromosomes: Traversable[A]) extends DeterministicProvider[A](chromosomes) with ChromosomeGenerator[A] {
  def this(chromosomes: A*) = this(chromosomes)

  def generateChromosome = nextElement
}
