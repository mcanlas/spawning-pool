package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

trait HomogenousCombinator[A] extends AlleleGenerator[A]
  with ChromosomeGenerator[Seq[A]]
  with Evolver[Seq[A]]
  with GeneIndexProvider
  with CrossoverParentProvider {
  type B = Seq[A]

  def mutate(chromosome: B) = chromosome.updated(nextGeneIndex(chromosome.size), generateAllele)

  def crossover(firstParent: B, secondParent: B) = {
    val size = Math.max(firstParent.size, secondParent.size)

    ???
  }

  def fill(size: Int): (=> A) => Seq[A] = Vector.fill[A](size)
}
