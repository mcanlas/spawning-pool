package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes of a fixed length.
  *
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  */

trait FixedLengthChromosome[A, B] extends IndexedChromosome[A, B] {
  // an optimization given that both chromosomes are the same length
  override def crossover(mate: A): A = ??? // TODO implement fixed ceiling crossover given rig
}
