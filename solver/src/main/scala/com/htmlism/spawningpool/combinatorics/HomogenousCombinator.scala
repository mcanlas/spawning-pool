package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

object HomogenousCombinator {
  def fixed[A](alleles: Seq[A], size: Int) = ???

  def variable[A](alleles: Seq[A], upperBound: Int) = ???
}

trait HomogenousCombinator[A] extends AlleleGenerator[A] with ChromosomeGenerator[Seq[A]] with Evolver[Seq[A]] {
}
