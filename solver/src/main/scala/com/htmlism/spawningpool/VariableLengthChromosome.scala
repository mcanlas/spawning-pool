package com.htmlism.spawningpool

trait VariableLengthChromosome[A] extends IndexedChromosome[A] {
  override def mutate: VariableLengthChromosome[A] = {
    // TODO given rig, choose add in n + 1, delete in n, or spot mutate

    ???
  }
}
