package com.htmlism.spawningpool.combinatorics

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
   * Generates an allele.
   *
   * This form of generation is used during mutation.
   *
   * @param allele The current allele being replaced
   * @return An allele
   */

  def generateAllele(allele: A): A = generateAllele
}
