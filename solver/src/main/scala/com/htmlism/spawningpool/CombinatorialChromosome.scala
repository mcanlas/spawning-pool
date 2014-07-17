package com.htmlism.spawningpool

/** A trait for chromosomes that support the generation of alleles from a collection of values.
  *
  * {{{
  *   def alleles: Seq[A]
  * }}}
  *
  * */

trait CombinatorialChromosome[A] extends HomogeneousChromosome[A] {
  def alleles: Seq[A]

  def generateAllele = alleles(randomAlleleIndex)

  def randomAlleleIndex = new util.Random().nextInt(alleles.size)
}
