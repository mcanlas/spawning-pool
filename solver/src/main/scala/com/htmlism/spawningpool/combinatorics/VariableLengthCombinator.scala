package com.htmlism.spawningpool.combinatorics

object VariableLengthCombinator {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}

trait VariableLengthCombinator[A]
  extends HomogenousCombinator[A]
  with LengthProvider
  with MutationMethodProvider {
  import com.htmlism.spawningpool.combinatorics.VariableLengthCombinator._

  def maximumSize: Int

  def generateChromosome: B = fill(nextLength(maximumSize))(generateAllele)

  override def mutate(chromosome: B) = nextMutationMethod match {
    case MutateGene => super.mutate(chromosome)
    case AddGene    => ???
    case RemoveGene => ???
  }

  override def crossover(firstParent: B, secondParent: B) = ???
}
