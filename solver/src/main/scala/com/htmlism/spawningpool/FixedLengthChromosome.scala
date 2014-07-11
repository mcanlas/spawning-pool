package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes of a fixed length. */

trait FixedLengthChromosome[A] extends IndexedChromosome[A] {
  // an optimization given that both chromosomes are the same length
  override def crossover(mate: Chromosome): FixedLengthChromosome[A] = ??? // TODO implement fixed ceiling crossover given rig
}
