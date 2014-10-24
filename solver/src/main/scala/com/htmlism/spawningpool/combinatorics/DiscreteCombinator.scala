package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.RandomIndexProvider

object DiscreteCombinator {
  def fixed[A](elements: Seq[A], size: Int) = ???

  def variable[A](elements: Seq[A], upperBound: Int) = ???
}

class DiscreteCombinator[A, B](val alleles: Seq[B])(implicit rip: RandomIndexProvider) extends DiscreteAlleleGenerator[B] with HomogenousCombinator[A, B] {
  def randomIndex(size: Int) = rip.randomIndex(size)
}
