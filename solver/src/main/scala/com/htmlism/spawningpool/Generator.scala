package com.htmlism.spawningpool

/**
  * A trait that represents a nullary operation for generating chromosomes of `A`.
  *
  * Chromosomes are typically generated randomly.
  *
  * @tparam A The type of the chromosome
  */

trait Generator[A] {
  /**
    * Generates a chromosome.
    *
    * @return A chromosome
    */

  def generate: A
}

object Generator {
  implicit val intGenerator:    Generator[Int]    = default.IntGenerator
  implicit val doubleGenerator: Generator[Double] = default.DoubleGenerator

  implicit val intArrayGenerator:    Generator[Array[Int]]    = default.FixedIntArrayGenerator
  implicit val doubleArrayGenerator: Generator[Array[Double]] = default.FixedDoubleArrayGenerator

  object VariableLength {
    implicit val intArrayGenerator:    Generator[Array[Int]]    = default.VariableIntArrayGenerator
    implicit val doubleArrayGenerator: Generator[Array[Double]] = default.VariableDoubleArrayGenerator
  }
}
