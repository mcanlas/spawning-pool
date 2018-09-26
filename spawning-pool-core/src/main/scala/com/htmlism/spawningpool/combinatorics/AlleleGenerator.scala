package com.htmlism.spawningpool.combinatorics

/**
  * A base trait for sources that can generate alleles, the individual parts of a chromosome
  *
  * @tparam A The type of the allele
  */
trait AlleleGenerator[A] {

  /**
    * Generates an allele.
    *
    * This form of generation is used during chromosome generation.
    *
    * @return An allele
    */
  def generateAllele: A

  /**
    * Generates an allele given an existing allele.
    *
    * This form of generation is used during mutation.
    *
    * @param allele The current allele being replaced
    * @return An allele
    */
  def generateAllele(allele: A): A = generateAllele
}
