package com.htmlism.spawningpool.combinatorics

trait FixedLengthCombinator[A] extends HomogenousCombinator[A, Seq[A]] {
  private type B = Seq[A]

  def size: Int

  def generateChromosome: B = HomogenousCombinator.SequenceFactory.fill(size)(generateAllele)

  override def crossover(firstParent: B, secondParent: B) = ???
}
