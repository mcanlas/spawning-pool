package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

object HomogenousCombinator {
  def fixed[A](alleles: Seq[A], size: Int) = ???

  def variable[A](alleles: Seq[A], upperBound: Int) = ???
}

trait HomogenousCombinator[A <: Seq[B], B] extends AlleleGenerator[B] with ChromosomeGenerator[A] with Evolver[A] {
  def mutate(chromosome: A) = ???

  def crossover(firstParent: A, secondParent: A) = ???
}
