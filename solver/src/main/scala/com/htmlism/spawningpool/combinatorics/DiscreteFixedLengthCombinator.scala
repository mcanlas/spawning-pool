package com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A <: Seq[B], B] extends FixedLengthCombinator[A, B] with DiscreteAlleleGenerator[B] with DefaultRandomProvider {
  def alleles = ???
}
