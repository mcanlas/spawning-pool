package com.htmlism.spawningpool

trait IndexedChromosome[A] extends Chromosome with HomogenousChromosome[A] {
  val genes: Seq[A]

  def mutate = ??? // TODO implement spot mutation here

  def crossover(mate: Chromosome) = ??? // TODO implement variable length crossover here
}
