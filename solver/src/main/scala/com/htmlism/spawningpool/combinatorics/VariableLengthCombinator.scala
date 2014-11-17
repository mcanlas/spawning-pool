package com.htmlism.spawningpool.combinatorics

object VariableLengthCombinator {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}

trait VariableLengthCombinator[A]
  extends HomogenousCombinator[A]
  with VariationProvider
  with LengthProvider
  with MutationMethodProvider {
  import com.htmlism.spawningpool.combinatorics.VariableLengthCombinator._

  def maximumSize: Int

  def generateChromosome: B = fill(nextLength(maximumSize))(generateAllele)

  override def mutate(chromosome: B) = nextMutationMethod match {
    case MutateGene => super.mutate(chromosome)
    case AddGene    => chromosome.patch(nextGeneIndexForInsertion(chromosome.size), Seq(generateAllele), 0)
    case RemoveGene => ???
  }
}
