package com.htmlism.spawningpool.combinatorics

class DiscreteVariableLengthCombinator[A](val alleles: Seq[A], val initialSize: Int)
    extends VariableLengthCombinator[A]
    with DiscreteAlleleGenerator[A]
    with DefaultRandomProvider
