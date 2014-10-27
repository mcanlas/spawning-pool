package com.htmlism.spawningpool.combinatorics

trait VariableLengthCombinator[A <: Seq[B], B] extends HomogenousCombinator[A, B] {
  override def mutate(chromosome: A) = ???

  override def crossover(firstParent: A, secondParent: A) = ???

  def generateChromosome = ???
}
