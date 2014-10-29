package com.htmlism.spawningpool.combinatorics

class DiscreteFixedLengthCombinator[A <: Seq[B], B] extends FixedLengthCombinator[A, B] with DiscreteAlleleGenerator[B] with DefaultRandomProvider {
  override def mutate(chromosome: A) = ???

  override def crossover(firstParent: A, secondParent: A) = ???

  def alleles = ???

  override def generateChromosome = ???

  def randomIndex(size: Int) = ???
}
