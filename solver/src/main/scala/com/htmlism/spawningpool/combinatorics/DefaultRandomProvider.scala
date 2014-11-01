package com.htmlism.spawningpool.combinatorics

trait DefaultRandomProvider extends
  AlleleIndexProvider with
  CrossoverParentProvider with
  GeneIndexProvider with
  MutationMethodProvider {
  private val rng = new util.Random

  def nextAlleleIndex(size: Int) = rng.nextInt(size)
}
