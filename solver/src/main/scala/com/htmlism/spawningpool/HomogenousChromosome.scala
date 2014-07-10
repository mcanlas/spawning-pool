package com.htmlism.spawningpool

trait HomogenousChromosome[A] {
  self: IndexedChromosome[A] =>

  def sample: A
}
