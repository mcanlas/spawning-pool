package com.htmlism.spawningpool.combinatorics

/**
 * This trait implements all of the combinatorial providers using Scala's random number generator.
 */

trait DefaultRandomProvider extends
  AlleleIndexProvider with
  CrossoverParentProvider with
  GeneIndexProvider with
  LengthProvider with
  VariationProvider with
  MutationMethodProvider {
  private val rng = new util.Random
  private val mutations = IndexedSeq(MutateGene, AddGene, RemoveGene)

  def nextAlleleIndex(size: Int): Int = guardedRandom(size)

  def nextGeneIndex(size: Int): Int = guardedRandom(size)

  def nextUseFirstParent: Boolean = rng.nextBoolean()

  def nextMutationMethod: MutationMethod = mutations(rng.nextInt(mutations.size))

  def nextLength(size: Int): Int = guardedRandom(size)

  // variation
  def nextGeneIndexForInsertion(size: Int): Int = guardedRandom(size + 1)
  def nextGeneIndexForRemoval(size: Int): Int   = guardedRandom(size)

  private def guardedRandom(n: Int) = {
    assert(n != 0, "a random index cannot be generated for an empty collection")

    rng.nextInt(n)
  }
}
