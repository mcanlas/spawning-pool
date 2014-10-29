package com.htmlism.spawningpool.combinatorics

trait DiscreteAlleleGenerator[A] extends AlleleGenerator[A] with DiscreteAlleleIndexProvider {
  def alleles: Seq[A]

  def generateAllele: A = alleles(randomDiscreteAlleleIndex(alleles.size))
}
