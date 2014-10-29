package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

trait HomogenousCombinator[A, B <: Seq[A]] extends AlleleGenerator[A]
  with ChromosomeGenerator[B]
  with Evolver[B]
  with GeneIndexProvider
  with CrossoverParentProvider {
  def mutate(chromosome: B) = ???

  def crossover(firstParent: B, secondParent: B) = ???

  def fill(size: Int): (=> A) => Seq[A] = Vector.fill[A](size)
}
