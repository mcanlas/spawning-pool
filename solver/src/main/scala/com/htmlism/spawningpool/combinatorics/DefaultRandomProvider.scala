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

  def nextAlleleIndex(size: Int): Int = safeRandom(size)

  def nextGeneIndex(size: Int): Int = safeRandom(size)

  def nextUseFirstParent: Boolean = rng.nextBoolean()

  def nextMutationMethod: MutationMethod = mutations(safeRandom(mutations.size))

  def nextLength(size: Int): Int = safeRandom(size)

  // variation
  def nextGeneIndexForInsertion(size: Int): Int = safeRandom(size + 1)
  def nextGeneIndexForRemoval(size: Int): Int   = safeRandom(size)

  private def safeRandom(n: Int) =
    if (n == 0)
      0
    else
      rng.nextInt(n)
}
