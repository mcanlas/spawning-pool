package com.htmlism.spawningpool.combinatorics

/**
 * This trait describes the source from which variable-length evolvers determine which allele's parents to select during crossover.
 *
 * Concrete classes will typically mix in `DefaultRandomProvider`.
 */

trait CrossoverParentProvider {
  /**
   * Returns the next boolean from this provider
   *
   * @return `true` if the first parent should be selected, `false` otherwise
   */

  def nextUseFirstParent: Boolean
}
