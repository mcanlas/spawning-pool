package com.htmlism.spawningpool

import com.htmlism.spawningpool.generation.*

/**
  * A trait that represents a nullary operation for generating chromosomes of `A`.
  *
  * Chromosomes are typically generated randomly.
  *
  * @tparam A
  *   The type of the chromosome
  */
trait Generator[A] {

  /**
    * Generates a chromosome.
    *
    * @return
    *   A chromosome
    */
  def generate: A
}

object Generator {
  implicit val intGenerator: Generator[Int]       = IntGenerator
  implicit val doubleGenerator: Generator[Double] = DoubleGenerator

  implicit val intArrayGenerator: Generator[Array[Int]] = FixedIntArrayGenerator
  implicit val doubleArrayGenerator: Generator[Array[Double]] =
    FixedDoubleArrayGenerator

  object VariableLength {
    implicit val intArrayGenerator: Generator[Array[Int]] =
      VariableIntArrayGenerator
    implicit val doubleArrayGenerator: Generator[Array[Double]] =
      VariableDoubleArrayGenerator
  }
}
