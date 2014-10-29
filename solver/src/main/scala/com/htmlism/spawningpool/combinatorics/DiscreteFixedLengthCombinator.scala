package com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A, B <: Seq[A]] extends FixedLengthCombinator[A, B] with DiscreteAlleleGenerator[A] with DefaultRandomProvider {
  def alleles = ???
}
