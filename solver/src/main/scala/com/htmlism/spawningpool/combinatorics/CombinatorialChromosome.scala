package com.htmlism.spawningpool.combinatorics

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
  /** A collection of possible values for genes
    *
    * @return A sequence of values
    */

  def alleles: Seq[B]

  def generateAllele = alleles(randomAlleleIndex)

  /** Randomly generates an allele index for mutation.
    *
    * @return An allele index
    */

  def randomAlleleIndex = new util.Random().nextInt(alleles.size)
}
