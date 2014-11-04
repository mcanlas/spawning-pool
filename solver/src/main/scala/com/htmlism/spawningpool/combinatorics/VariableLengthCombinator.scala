package com.htmlism.spawningpool.combinatorics

object VariableLengthCombinator {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}

trait VariableLengthCombinator[A]
  extends HomogenousCombinator[A]
  with MutationMethodProvider {
  def maximumSize: Int

  def generateChromosome: B = ???

  override def mutate(chromosome: B) = ???

  override def crossover(firstParent: B, secondParent: B) = ???
}
