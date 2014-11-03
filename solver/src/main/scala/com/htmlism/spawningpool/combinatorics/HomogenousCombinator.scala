package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.{ ChromosomeGenerator, Evolver }

trait HomogenousCombinator[A] extends AlleleGenerator[A]
  with ChromosomeGenerator[Seq[A]]
  with Evolver[Seq[A]]
  with GeneIndexProvider
  with CrossoverParentProvider {
  type B = Seq[A]

  def mutate(chromosome: B): B = chromosome.updated(nextGeneIndex(chromosome.size), generateAllele)

  def crossover(firstParent: B, secondParent: B): B = {
    val size = Math.max(firstParent.size, secondParent.size)

    (0 until size).flatMap { i =>
      val parent = if (nextUseFirstParent) firstParent else secondParent

      if (parent.isDefinedAt(i))
        parent(i) :: Nil
      else
        Nil
    }
  }

  def fill(size: Int): (=> A) => Seq[A] = Vector.fill[A](size)
}
