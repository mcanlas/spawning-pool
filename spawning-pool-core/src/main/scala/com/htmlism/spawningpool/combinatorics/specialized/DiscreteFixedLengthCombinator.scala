package com.htmlism.spawningpool.combinatorics.specialized

import scala.reflect.ClassTag

import com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A](alleles: Seq[A], size: Int)(
    implicit val classTag: ClassTag[A])
    extends combinatorics.DiscreteFixedLengthCombinator(alleles, size)
    with HomogenousCombinator[A]
