package com.htmlism.spawningpool.combinatorics

trait VariableLengthCombinator[A] extends HomogenousCombinator[A, Seq[A]] with MutationMethodProvider {
  type B = Seq[A]

  override def mutate(chromosome: B) = ???

  override def crossover(firstParent: B, secondParent: B) = ???

  def generateChromosome = ???
}
