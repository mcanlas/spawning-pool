package com.htmlism.spawningpool.combinatorics

class FixedLengthCombinator[A <: Seq[B], B] extends DiscreteCombinator[A, B] {
  override def mutate(chromosome: A) = ???

  override def crossover(firstParent: A, secondParent: A) = ???

  def alleles = ???

  def generateChromosome = ???

  def randomIndex(size: Int) = ???
}
