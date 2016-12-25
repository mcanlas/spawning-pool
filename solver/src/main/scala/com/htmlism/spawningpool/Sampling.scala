package com.htmlism.spawningpool

/**
  * A trait that represents a strategy for picking one chromosome from a population.
  *
  */

trait Sampling {
  /**
    * Samples one chromosome from the population.
    *
    * @param xs A collection of chromosomes
    * @tparam A The type of the chromosomes
    * @return A chromosome
    */

  def sample[A](xs: TraversableOnce[A]): A
}

object RandomSampler extends Sampling {
  import scala.util.Random

  def sample[A](xs: TraversableOnce[A]): A = {
    val seq = xs.toIndexedSeq
    val randomIndex = Random.nextInt(seq.length)

    seq(randomIndex)
  }
}
