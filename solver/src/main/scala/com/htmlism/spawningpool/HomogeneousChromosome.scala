package com.htmlism.spawningpool

trait HomogeneousChromosome[A] {
  self: IndexedChromosome[A] =>

  def generateAllele: A
}
