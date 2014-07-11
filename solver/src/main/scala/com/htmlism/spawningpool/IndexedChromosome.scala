package com.htmlism.spawningpool

trait IndexedChromosome[A] extends Chromosome with HomogeneousChromosome[A] {
  val genes: Seq[A]

  def mutate: IndexedChromosome[A] = ??? // TODO implement spot mutation here

  def crossover(mate: Chromosome): IndexedChromosome[A] = ??? // TODO implement variable length crossover here
}
