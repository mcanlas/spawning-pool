package com.htmlism.spawningpool

/** A trait for chromosomes that support the generation of alleles.
  *
  * {{{
  *   def generateAllele: B
  * }}}
  *
  * Allele generation is used by the mutation operators found in [[IndexedChromosome]]
  * and [[VariableLengthChromosome]].
  *
  * Directly inherit from this trait if the values of the genes in the chromosome are continuous
  * (i.e. `Integer`, `Double`, etc.). A typical implementation for `generateAllele` would
  * involve a random number generator. For discrete spaces, inherit from [[CombinatorialChromosome]].
  *
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  * */

trait HomogeneousChromosome[A, B] extends Chromosome[A] {
  def generateAllele: B
}
