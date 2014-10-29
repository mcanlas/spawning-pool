package com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A, B <: Seq[A]](val alleles: Seq[A], val size: Int)
  extends FixedLengthCombinator[A, B]
  with DiscreteAlleleGenerator[A]
  with DefaultRandomProvider {
}
