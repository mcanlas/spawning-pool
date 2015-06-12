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

  def nextAlleleIndex(size: Int): Int = rng.nextInt(size)

  def nextGeneIndex(size: Int): Int = rng.nextInt(size)

  def nextUseFirstParent: Boolean = rng.nextBoolean()

  def nextMutationMethod: MutationMethod = mutations(rng.nextInt(mutations.size))

  def nextLength(size: Int): Int = rng.nextInt(size)

  // variation
  def nextGeneIndexForInsertion(size: Int): Int = rng.nextInt(size + 1)
  def nextGeneIndexForRemoval(size: Int): Int   = rng.nextInt(size)
}
