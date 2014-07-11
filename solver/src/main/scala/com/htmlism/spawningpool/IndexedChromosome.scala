package com.htmlism.spawningpool

/** The base trait for chromosomes that are backed by a collection of some type A.
  *
  * This trait provides a default implementation for mutation. Mutation occurs by
  * replacing a random gene with a randomly generated allele.
  *
  */

trait IndexedChromosome[A] extends Chromosome with HomogeneousChromosome[A] {
  val genes: Seq[A]

  def mutate: IndexedChromosome[A] = ??? // TODO implement spot mutation here

  def crossover(mate: Chromosome): IndexedChromosome[A] = ??? // TODO implement variable length crossover here
}
