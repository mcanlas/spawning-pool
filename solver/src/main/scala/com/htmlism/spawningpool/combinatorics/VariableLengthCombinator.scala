package com.htmlism.spawningpool.combinatorics

trait VariableLengthCombinator[A, B <: Seq[A]] extends HomogenousCombinator[A, B] with MutationMethodProvider {
  override def mutate(chromosome: B) = ???

  override def crossover(firstParent: B, secondParent: B) = ???

  def generateChromosome = ???
}
