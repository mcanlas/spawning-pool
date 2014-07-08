package com.htmlism

package object spawningpool {
  implicit object DefaultRandomIndexGenerator extends RandomIndexGenerator {
    private val rng = new util.Random

    def randomIndex(size: Int) = rng.nextInt(size)
  }
}
