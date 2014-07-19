package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes of a fixed length.
  *
  * @tparam A The type for a single gene
  * @tparam B The trait or class extending this trait
  *
  */

trait FixedLengthChromosome[B, A] extends IndexedChromosome[B, A] {
  // an optimization given that both chromosomes are the same length
  override def crossover(mate: B): B = ??? // TODO implement fixed ceiling crossover given rig
}
