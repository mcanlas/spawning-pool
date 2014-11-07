package com.htmlism.spawningpool.combinatorics

/**
 * This trait implements all of the combinatorial providers using Scala's random number generator.
 */

trait DefaultRandomProvider extends
  AlleleIndexProvider with
  CrossoverParentProvider with
  GeneIndexProvider with
  LengthProvider with
  MutationMethodProvider {
  private val rng = new util.Random

  def nextAlleleIndex(size: Int) = rng.nextInt(size)

  def nextGeneIndex(size: Int) = rng.nextInt(size)

  def nextUseFirstParent = rng.nextBoolean()

  def nextMutationMethod = rng.nextInt(3)

  def nextLength(size: Int) = rng.nextInt(size)
}
