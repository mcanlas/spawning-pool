package com.htmlism.spawningpool.combinatorics

class DiscreteVariableLengthCombinator[A <: Seq[B], B] extends VariableLengthCombinator[A, B] with DiscreteAlleleGenerator[B] with DefaultRandomProvider {
  def alleles = ???
}
