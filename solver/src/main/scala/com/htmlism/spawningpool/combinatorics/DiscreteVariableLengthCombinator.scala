package com.htmlism.spawningpool.combinatorics

class DiscreteVariableLengthCombinator[A, B <: Seq[A]] extends VariableLengthCombinator[A, B] with DiscreteAlleleGenerator[A] with DefaultRandomProvider {
  def alleles = ???
}
