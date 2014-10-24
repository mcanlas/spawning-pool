package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.ChromosomeGenerator

class FixedLengthChromosomeGenerator[A <: FixedLengthChromosome[A, B], B](elements: Set[B], size: Int) extends ChromosomeGenerator[A] {
  def generateChromosome = ???
}
