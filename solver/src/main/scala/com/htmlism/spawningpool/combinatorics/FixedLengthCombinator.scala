package com.htmlism.spawningpool.combinatorics

trait FixedLengthCombinator[A] extends HomogenousCombinator[A] {
  def size: Int

  def generateChromosome: B = fill(size)(generateAllele)

  override def crossover(firstParent: B, secondParent: B) = ???
}
