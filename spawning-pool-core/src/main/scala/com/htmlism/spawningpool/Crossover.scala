package com.htmlism.spawningpool

/**
  * A typeclass that represents a crossover operation for chromosomes.
  *
  * This operation can accept an arbitrary number of chromosomes, though genetic crossover typically involves only two
  * parents.
  *
  * @tparam A
  *   The type of the chromosomes
  */
trait Crossover[A] {

  /**
    * Returns a new chromosome given a collection of parent chromosomes.
    *
    * @param xs
    *   The parent chromosomes
    * @return
    *   A chromosome
    */
  def crossover(xs: List[A]): A
}

object IntUniformCrossover extends Crossover[Int] {
  def crossover(xs: List[Int]): Int = ???
}

object DoubleUniformCrossover extends Crossover[Double] {
  def crossover(xs: List[Double]): Double = ???
}
