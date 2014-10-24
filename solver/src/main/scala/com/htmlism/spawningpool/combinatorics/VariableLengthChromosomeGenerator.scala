package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.ChromosomeGenerator

class VariableLengthChromosomeGenerator[A <: VariableLengthChromosome[A, B], B](elements: Set[B]) extends ChromosomeGenerator[A] {
  def generateChromosome = ???
}
