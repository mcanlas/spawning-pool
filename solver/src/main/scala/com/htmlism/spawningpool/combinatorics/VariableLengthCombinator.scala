package com.htmlism.spawningpool.combinatorics

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
  /**
   * The initial number of elements for every chromosome generated.
   *
   * @return A number
   */
  def initialSize: Int

  def generateChromosome: B = fill(nextLength(initialSize))(generateAllele)

  override def mutate(chromosome: B): B = nextMutationMethod match {
    case MutateGene => super.mutate(chromosome)
    case AddGene    => addGene(chromosome)
    case RemoveGene => chromosome.patch(nextGeneIndexForRemoval(chromosome.size), Nil, 1)
  }

  private def addGene(chromosome: B) = chromosome.patch(nextGeneIndexForInsertion(chromosome.size), Seq(generateAllele), 0)
}

/**
 * An algebra for different types of mutation.
 */

sealed trait MutationMethod

case object MutateGene extends MutationMethod
case object AddGene    extends MutationMethod
case object RemoveGene extends MutationMethod
