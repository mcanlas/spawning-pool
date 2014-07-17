package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes of a fixed length. */

trait FixedLengthChromosome[B, A] extends IndexedChromosome[B, A] {
  // an optimization given that both chromosomes are the same length
  override def crossover(mate: B): B = ??? // TODO implement fixed ceiling crossover given rig
}
