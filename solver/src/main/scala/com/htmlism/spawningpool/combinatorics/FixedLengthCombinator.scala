package com.htmlism.spawningpool.combinatorics

trait FixedLengthCombinator[A] extends HomogenousCombinator[A] {
  def size: Int

  def generateChromosome: B = fill(size)(generateAllele)

  override def crossover(firstParent: B, secondParent: B) =
    (0 until size).flatMap { i =>
      val parent = if (nextUseFirstParent) firstParent else secondParent

      if (parent.isDefinedAt(i))
        parent(i) :: Nil
      else
        Nil
    }
}
