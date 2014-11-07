package com.htmlism.spawningpool.combinatorics

/**
 * This trait describes the source from which variable-length evolvers will determine which mutation method to use
 *
 * Concrete classes will typically mix in `DefaultRandomProvider`.
 */

trait MutationMethodProvider {
  /**
   * Returns the next mutation method from this provider, encoded as an integer
   *
   * {{{
   * val MutateGene = 0
   * val AddGene    = 1
   * val RemoveGene = 2
   * }}}
   *
   * @return A mutation method, encoded as an integer
   */

  def nextMutationMethod: Int
}
