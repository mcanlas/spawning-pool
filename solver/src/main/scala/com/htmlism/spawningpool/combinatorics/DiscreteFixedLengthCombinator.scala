package com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A](val alleles: Seq[A], val size: Int)
  extends FixedLengthCombinator[A]
  with DiscreteAlleleGenerator[A]
  with DefaultRandomProvider {
}
