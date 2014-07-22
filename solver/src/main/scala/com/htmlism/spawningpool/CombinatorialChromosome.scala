package com.htmlism.spawningpool

/** A trait for chromosomes that support the generation of alleles from a collection of values.
  *
  * {{{
  *   def alleles: Seq[B]
  * }}}
  *
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  * */

trait CombinatorialChromosome[A, B] extends HomogeneousChromosome[A, B] {
  def alleles: Seq[B]

  def generateAllele = alleles(randomAlleleIndex)

  def randomAlleleIndex = new util.Random().nextInt(alleles.size)
}
