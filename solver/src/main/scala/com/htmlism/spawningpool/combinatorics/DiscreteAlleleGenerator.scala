package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.AlleleGenerator

trait DiscreteAlleleGenerator[A] extends AlleleGenerator[A] {
  def generateAllele: A

  def alleles: Seq[A]

  def randomAlleleIndex = new util.Random().nextInt(alleles.size)
}
