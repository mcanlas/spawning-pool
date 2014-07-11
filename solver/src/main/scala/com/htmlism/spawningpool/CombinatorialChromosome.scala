package com.htmlism.spawningpool

trait CombinatorialChromosome[A] extends HomogeneousChromosome[A] {
  self: IndexedChromosome[A] =>

  val elements: Seq[A]

  def generateAllele = ??? // TODO given rig
}
