package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class VariableLengthCombinatorSpec extends Specification {
  "A variable-length generator" should {
  }
}

class VariableTestCombinator
  extends VariableLengthCombinator[Symbol]
  with DiscreteAlleleGenerator[Symbol] {
  def maximumSize: Int = ???

  def alleles: Seq[Symbol] = ???

  def nextMutationMethod: Int = ???

  def nextAlleleIndex(size: Int): Int = ???

  def nextUseFirstParent: Boolean = ???

  def nextGeneIndex(size: Int): Int = ???

  def nextLength(maximum: Int): Int = ???
}
