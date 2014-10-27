package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

trait HomogenousCombinator[A <: Seq[B], B] extends AlleleGenerator[B] with ChromosomeGenerator[A] with Evolver[A] {
  def mutate(chromosome: A) = ???

  def crossover(firstParent: A, secondParent: A) = ???
}
