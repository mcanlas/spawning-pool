package com.htmlism.spawningpool

/** A trait for chromosomes that support the generation of alleles from a collection of values. */

trait CombinatorialChromosome[A] extends HomogeneousChromosome[A] {
  self: IndexedChromosome[A] =>

  val elements: Seq[A]

  def generateAllele = ??? // TODO given rig
}
