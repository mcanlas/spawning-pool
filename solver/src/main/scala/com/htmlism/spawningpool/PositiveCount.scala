package com.htmlism.spawningpool

object PositiveCount {
  def apply(count: Int) =
    if (count > 0)
      new PositiveCount(count)
    else
      throw new IllegalArgumentException(s"$count is not positive")
}

class PositiveCount private (val count: Int) extends AnyVal
