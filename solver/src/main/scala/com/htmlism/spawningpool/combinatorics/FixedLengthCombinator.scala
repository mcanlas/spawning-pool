package com.htmlism.spawningpool.combinatorics

/** The base trait for combinators that create and manipulate chromosomes of a fixed length.
  *
  * @tparam A The type of each gene in the chromosome
  *
  */

trait FixedLengthCombinator[A] extends HomogenousCombinator[A] {
  def size: Int

  def generateChromosome: B = fill(size)(generateAllele)

  override def crossover(firstParent: B, secondParent: B): B =
    (0 until size).flatMap { i =>
      val parent = if (nextUseFirstParent) firstParent else secondParent

      if (parent.isDefinedAt(i))
        parent(i) :: Nil
      else
        Nil
    }
}
