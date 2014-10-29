package com.htmlism.spawningpool.combinatorics

trait FixedLengthCombinator[A] extends HomogenousCombinator[A, Seq[A]] {
  type B = Seq[A]

  def size: Int

  def generateChromosome: B = Vector.fill(size)(generateAllele)

  override def crossover(firstParent: B, secondParent: B) = ???
}
