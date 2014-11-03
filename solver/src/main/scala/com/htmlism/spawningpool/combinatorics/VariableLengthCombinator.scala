package com.htmlism.spawningpool.combinatorics

trait VariableLengthCombinator[A]
  extends HomogenousCombinator[A]
  with MutationMethodProvider {
  def maximumSize: Int

  def generateChromosome: B = ???

  override def mutate(chromosome: B) = ???

  override def crossover(firstParent: B, secondParent: B) = ???
}
