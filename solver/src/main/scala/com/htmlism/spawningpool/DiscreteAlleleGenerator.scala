package com.htmlism.spawningpool

trait DiscreteAlleleGenerator[A] extends AlleleGenerator[A] {
  def generateAllele: A

  def alleles: Seq[A]

  def randomAlleleIndex = new util.Random().nextInt(alleles.size)
}
