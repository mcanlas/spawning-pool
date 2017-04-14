package com.htmlism.spawningpool.combinatorics

/**
 * This trait describes the source from which evolvers determine where spot mutation occurs
 *
 * Concrete classes will typically mix in `DefaultRandomProvider`.
 */

trait GeneIndexProvider {
  /**
   * Returns the next gene index from this provider
   *
   * @param size The length of the chromosome where this index will be used
   * @return An index
   */

  def nextGeneIndex(size: Int): Int
}
