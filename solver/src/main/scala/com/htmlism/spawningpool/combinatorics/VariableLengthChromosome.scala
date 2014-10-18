package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.combinatorics.IndexedChromosome

/** The base trait for homogeneous chromosomes of variable length.
  *
  * This trait augments the default mutation operator specified by [[IndexedChromosome]]
  * with two other alternatives. Mutation occurs by randomly choosing one of these three
  * operations:
  *
  *  - Add a randomly generated gene in a random location
  *  - Delete a random gene
  *  - Mutate a random gene (via [[IndexedChromosome]])
  *
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  */

trait VariableLengthChromosome[A <: VariableLengthChromosome[A, B], B] extends IndexedChromosome[A, B] {
  import com.htmlism.spawningpool.combinatorics.VariableLengthChromosome._

  override def mutate: A = randomMutationOperation match {
    case MutateGene => super.mutate
    case AddGene    => construct(genes.patch(randomNewGeneIndex, Seq(generateAllele), 0))
    case RemoveGene => construct(genes.patch(randomGeneIndex, Nil, 1))
  }

  def randomMutationOperation = new util.Random().nextInt(3)

  def randomNewGeneIndex = new util.Random().nextInt(genes.size + 1)
}

object VariableLengthChromosome {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}
