package com.htmlism.spawningpool.combinatorics

class DiscreteVariableLengthCombinator[A](val alleles: Seq[A])
  extends VariableLengthCombinator[A]
  with DiscreteAlleleGenerator[A]
  with DefaultRandomProvider {
}
