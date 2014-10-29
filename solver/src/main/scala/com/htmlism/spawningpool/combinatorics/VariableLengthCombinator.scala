package com.htmlism.spawningpool.combinatorics

trait VariableLengthCombinator[A] extends HomogenousCombinator[A, Seq[A]] with MutationMethodProvider {
  private type B = Seq[A]

  def generateChromosome: B = ???

  override def mutate(chromosome: B) = ???

  override def crossover(firstParent: B, secondParent: B) = ???
}
