package com.htmlism.spawningpool

/** A trait for chromosomes that support the generation of alleles.
  *
  * Allele generation is used by the mutation operators found in [[IndexedChromosome]]
  * and [[VariableLengthChromosome]].
  *
  * Directly inherit from this trait if the values of the genes in the chromosome are continuous
  * (i.e. `Integer`, `Double`, etc.). A typical implementation for `generateAllele` would
  * involve a random number generator. For discrete spaces, inherit from [[CombinatorialChromosome]].
  *
  * */

trait HomogeneousChromosome[A] extends Chromosome {
  def generateAllele: A
}
