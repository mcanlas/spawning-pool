package com.htmlism.spawningpool.combinatorics

object DiscreteCombinator {
  def fixed[A](elements: Seq[A], size: Int) = ???

  def variable[A](elements: Seq[A], upperBound: Int) = ???
}

trait DiscreteCombinator[A] extends DiscreteAlleleGenerator[A] with HomogenousCombinator[A]
