package com.htmlism.spawningpool

trait FixedLengthChromosome[A] extends IndexedChromosome[A] {
  // an optimization given that both chromosomes are the same length
  override def crossover(mate: Chromosome) = ??? // TODO implement fixed ceiling crossover given rig
}
