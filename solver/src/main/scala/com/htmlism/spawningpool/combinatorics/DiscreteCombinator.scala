package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.RandomIndexProvider

object DiscreteCombinator {
  def fixed[A, B](elements: Seq[A], builder: Traversable[A] => B, size: Int) = ???

  def variable[A, B](elements: Seq[A], builder: Traversable[A] => B, upperBound: Int) = ???
}

class DiscreteCombinator[A, B](builder: Traversable[B] => A, val alleles: Seq[B])(implicit rip: RandomIndexProvider) extends DiscreteAlleleGenerator[B] with HomogenousCombinator[A, B] {
  def randomIndex(size: Int) = rip.randomIndex(size)
}
