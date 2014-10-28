package com.htmlism.spawningpool

package object combinatorics {
  implicit object DefaultRandomProvider {
    private val rng = new util.Random
  }
}
