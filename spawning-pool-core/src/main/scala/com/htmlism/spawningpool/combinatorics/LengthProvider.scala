package com.htmlism.spawningpool.combinatorics

/**
  * This trait describes the source from which variable-length generators will determine how big the next chromosome
  * will be
  *
  * Concrete classes will typically mix in `DefaultRandomProvider`.
  */
trait LengthProvider {

  /**
    * Returns the next length from this provider
    *
    * @param maximum
    *   The maximum possible length (inclusive)
    * @return
    *   A length
    */
  def nextLength(maximum: Int): Int
}
