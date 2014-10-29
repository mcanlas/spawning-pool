package com.htmlism.spawningpool.combinatorics

trait DefaultRandomProvider extends
  DiscreteAlleleIndexProvider with
  CrossoverParentProvider with
  GeneIndexProvider with
  MutationMethodProvider {
  private val rng = new util.Random
}
