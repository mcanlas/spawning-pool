package com.htmlism.spawningpool.combinatorics

trait GeneIndexProvider {
  def nextGeneIndex(size: Int): Int
}
