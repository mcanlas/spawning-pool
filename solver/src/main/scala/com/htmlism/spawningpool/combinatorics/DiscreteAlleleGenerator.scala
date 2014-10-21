package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.RandomIndexProvider

trait DiscreteAlleleGenerator[A] extends AlleleGenerator[A] with RandomIndexProvider {
  def alleles: Seq[A]

  def generateAllele: A = alleles(randomIndex(alleles.size))
}
