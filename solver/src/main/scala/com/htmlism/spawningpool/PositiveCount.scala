package com.htmlism.spawningpool

object PositiveCount {
  def apply(count: Int): PositiveCount =
    if (count > 0)
      new PositiveCount(count)
    else
      throw new IllegalArgumentException(s"$count is not positive")
}

class PositiveCount private (val count: Int) extends AnyVal {
  /**
   * Returns a new positive count with one less. Could throw an exception if the count is already 1.
   *
   * @return A positive count
   */

  def minusOne: PositiveCount = PositiveCount(count - 1)
}
