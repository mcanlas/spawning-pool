package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.ChromosomeGenerator
import com.htmlism.spawningpool.Evolver

/**
  * A trait for combinators that create and manipulate chromosomes backed by a sequence.
  *
  * This trait provides a default implementation for mutation. Mutation occurs by replacing a random gene with a
  * randomly generated allele.
  *
  * @tparam A
  *   The type of each gene in the chromosome
  */
trait HomogenousCombinator[A]
    extends AlleleGenerator[A]
    with ChromosomeGenerator[Seq[A]]
    with Evolver[Seq[A]]
    with GeneIndexProvider
    with CrossoverParentProvider {

  /** The type of the chromosome */
  type B = Seq[A]

  def mutate(chromosome: B): B =
    if (chromosome.isEmpty)
      chromosome
    else {
      val index          = nextGeneIndex(chromosome.size)
      val alleleToUpdate = chromosome(index)

      chromosome.updated(index, generateAllele(alleleToUpdate))
    }

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

  /**
    * Generates a chromosome of a given size.
    *
    * @param size
    *   The number of genes in the chromosome
    * @return
    *   A chromosome
    */
  def fill(size: Int): (=> A) => Seq[A] = Vector.fill[A](size)
}
