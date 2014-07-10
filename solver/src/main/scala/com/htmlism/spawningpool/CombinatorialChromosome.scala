package com.htmlism.spawningpool

trait CombinatorialChromosome[A] extends HomogenousChromosome[A] {
  self: IndexedChromosome[A] =>

  val elements: Seq[A]

  def sample = ??? // TODO given rig
}
