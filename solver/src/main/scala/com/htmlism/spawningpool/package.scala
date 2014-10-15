package com.htmlism

package object spawningpool {
  implicit object DefaultRandomIndexGenerator extends RandomIndexGenerator {
    private val rng = new util.Random

    def randomIndex(size: Int) = rng.nextInt(size)
  }

  def memoize[A, B](f: A => B): A => B = {
    val cache = collection.mutable.Map[A, B]()

    { key =>
      if (!cache.contains(key))
        cache(key) = f(key)

      cache(key)
    }
  }
}
