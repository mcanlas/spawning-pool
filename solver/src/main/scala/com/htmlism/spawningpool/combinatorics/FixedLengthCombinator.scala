package com.htmlism.spawningpool.combinatorics

trait FixedLengthCombinator[A, B <: Seq[A]] extends HomogenousCombinator[A, B] {
  def size: Int

  override def crossover(firstParent: B, secondParent: B) = ???

  def generateChromosome = ???
}
