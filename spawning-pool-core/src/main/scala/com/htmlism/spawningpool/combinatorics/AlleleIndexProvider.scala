package com.htmlism.spawningpool.combinatorics

/**
  * This trait describes the source from which discrete allele generators get their indices.
  *
  * Concrete classes will typically mix in `DefaultRandomProvider`.
  */
trait AlleleIndexProvider {

  /**
    * Returns the next allele index from this provider
    *
    * @param size The size of the collection where the index will be used
    * @return An index
    */
  def nextAlleleIndex(size: Int): Int
}
