package com.htmlism.spawningpool.combinatorics

/**
 * This trait describes the source from which variable-length evolvers will determine which mutation method to use
 *
 * Concrete classes will typically mix in `DefaultRandomProvider`.
 */

trait MutationMethodProvider {
  /**
   * Returns the next mutation method from this provider. The value will be one of `MutateGene`, `AddGene`, and `RemoveGene`.
   *
   * @return A mutation method
   */

  def nextMutationMethod: MutationMethod
}
