package com.htmlism.spawningpool.combinatorics

/**
 * A companion object that provides constants for different types of mutation.
 */

object VariableLengthCombinator {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}

/**
 * The base trait for combinators that create and manipulate chromosomes of a variable length.
 *
 * This trait augments the default mutation operator defined in [[HomogenousCombinator]]
 * with two other alternatives. Mutation occurs by randomly choosing one of these three
 * operations:
 *
 *  - Add a randomly generated gene in a random location
 *  - Delete a random gene
 *  - Mutate a random gene (via [[HomogenousCombinator]])
 *
 * @tparam A The type of each gene in the chromosome
 */

trait VariableLengthCombinator[A]
  extends HomogenousCombinator[A]
  with VariationProvider
  with LengthProvider
  with MutationMethodProvider {
  import com.htmlism.spawningpool.combinatorics.VariableLengthCombinator._

  def maximumSize: Int

  def generateChromosome: B = fill(nextLength(maximumSize))(generateAllele)

  override def mutate(chromosome: B): B = nextMutationMethod match {
    case MutateGene => super.mutate(chromosome)
    case AddGene    => chromosome.patch(nextGeneIndexForInsertion(chromosome.size), Seq(generateAllele), 0)
    case RemoveGene => chromosome.patch(nextGeneIndexForRemoval(chromosome.size), Nil, 1)
  }
}
