package com.htmlism.spawningpool.combinatorics

class DiscreteVariableLengthCombinator[A <: Seq[B], B] extends VariableLengthCombinator[A, B] with DiscreteAlleleGenerator[B] with DefaultRandomProvider {
  override def mutate(chromosome: A) = ???

  override def crossover(firstParent: A, secondParent: A) = ???

  def alleles = ???

  override def generateChromosome = ???
}
