package com.htmlism.spawningpool.combinatorics

trait HomogenousGenerator[A, B] {
  def build(chromosomes: Traversable[B]): A
}
