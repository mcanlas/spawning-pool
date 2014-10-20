package com.htmlism.spawningpool

class DeterministicGenerator[A](private var elements: Traversable[A]) {
  def nextElement =
    if (elements.isEmpty)
      throw new NoSuchElementException
    else {
      val cur = elements.head
      elements = elements.tail
      cur
    }
}
