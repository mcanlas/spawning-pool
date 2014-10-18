package com.htmlism.spawningpool.combinatorics

class FixedLengthChromosomeGenerator[A <: FixedLengthChromosome[A, B], B](elements: Set[B], size: Int) extends ChromosomeGenerator[A] {
  def generateChromosome = ???
}
