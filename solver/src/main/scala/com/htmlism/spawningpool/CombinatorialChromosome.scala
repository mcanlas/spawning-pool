package com.htmlism.spawningpool

trait CombinatorialChromosome[A] extends HomogeneousChromosome[A] {
  self: IndexedChromosome[A] =>

  val elements: Seq[A]

  def sample = ??? // TODO given rig
}
