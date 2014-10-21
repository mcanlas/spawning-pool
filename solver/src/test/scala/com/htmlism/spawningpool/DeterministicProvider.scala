package com.htmlism.spawningpool

object DeterministicProvider {
  def apply[A](elements: A*): DeterministicProvider[A] = new DeterministicProvider(elements)
}

class DeterministicProvider[A](private var elements: Traversable[A]) {
  def nextElement =
    if (elements.isEmpty)
      throw new NoSuchElementException
    else {
      val cur = elements.head
      elements = elements.tail
      cur
    }
}
