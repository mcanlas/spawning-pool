package com.htmlism

/**
  * The `spawning-pool` framework enables the search and generation of solutions encoded as a chromosome over a fitness
  * landscape, all in a generic manner typical of Scala libraries.
  *
  * Because genetic algorithms are computationally intensive, this framework uses futures to perform evolution
  * concurrently.
  */
package object spawningpool {
  implicit object DefaultRandomIndexProvider extends RandomIndexProvider {
    private val rng = new util.Random

    def randomIndex(size: Int): Int = rng.nextInt(size)
  }

  implicit def countToInt(count: PositiveCount): Int = count.count

  def memoize[A, B](f: A => B): A => B = {
    val cache = collection.mutable.Map[A, B]()

    { key =>
      if (!cache.contains(key))
        cache(key) = f(key)

      cache(key)
    }
  }

  implicit val asdf: Mutation[Int] = IntMutation

  implicit class MutationOps[A: Mutation](x: A) {
    def mutate: A = implicitly[Mutation[A]].mutate(x)
  }

  def muz[A: Mutation](x: A): A = implicitly[Mutation[A]].mutate(x)
}
