package com.htmlism.spawningpool.combinatorics

/**
 * This trait describes the source from which variable-length evolvers will determine the mechanics of mutation
 *
 * Concrete classes will typically mix in `DefaultRandomProvider`.
 */

trait VariationProvider {
  /**
   * Returns the next gene index for insertion from this provider
   *
   * @param size The size of the chromosome to modify
   * @return An index
   */

  def nextGeneIndexForInsertion(size: Int): Int
}
