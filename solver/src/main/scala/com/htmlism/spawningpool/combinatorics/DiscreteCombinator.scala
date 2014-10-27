package com.htmlism.spawningpool.combinatorics

object DiscreteCombinator {
  def fixed[A](elements: Seq[A], size: Int) = ???

  def variable[A](elements: Seq[A], upperBound: Int) = ???
}

trait DiscreteCombinator[A <: Seq[B], B] extends DiscreteAlleleGenerator[B] with HomogenousCombinator[A, B]
