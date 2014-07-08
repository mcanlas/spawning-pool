package com.htmlism.spawningpool

class DeterministicGenerator[T](private var elements: Traversable[T]) {
  def nextElement =
    if (elements.isEmpty)
      throw new NoSuchElementException
    else {
      val cur = elements.head
      elements = elements.tail
      cur
    }
}
