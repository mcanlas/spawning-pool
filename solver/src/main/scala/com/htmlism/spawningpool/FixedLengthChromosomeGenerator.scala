package com.htmlism.spawningpool

class FixedLengthChromosomeGenerator[A <: FixedLengthChromosome[A, B], B](elements: Set[B], size: Int) extends ChromosomeGenerator[A] {
  def generateChromosome = ???
}
