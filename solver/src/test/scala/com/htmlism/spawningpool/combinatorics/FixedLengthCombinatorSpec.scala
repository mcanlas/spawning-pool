package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class FixedLengthCombinatorSpec extends Specification {
  "A fixed-length generator" should {
  }
}

// TODO drop the abstract and attempt to implement this in intellij
abstract class FixedTestCombinator
  extends HomogenousCombinator[Symbol, Vector[Symbol]]
  with DiscreteAlleleGenerator[Symbol]
