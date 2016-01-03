package com.htmlism.spawningpool

import scala.util.Random

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
  implicit val intGenerator    = IntGenerator
  implicit val doubleGenerator = DoubleGenerator

  implicit val intArrayGenerator    = new IntArrayGenerator(100)
  implicit val doubleArrayGenerator = new DoubleArrayGenerator(100)
}

object IntGenerator extends Generator[Int] {
  def generate: Int = Random.nextInt
}

object DoubleGenerator extends Generator[Double] {
  def generate: Double = Random.nextDouble
}

class IntArrayGenerator(n: Int) extends Generator[Array[Int]] {
  def generate: Array[Int] = {
    val length = Random.nextInt(n)

    Array.fill(length)(Random.nextInt)
  }
}

class DoubleArrayGenerator(n: Int) extends Generator[Array[Double]] {
  def generate: Array[Double] = {
    val length = Random.nextInt(n)

    Array.fill(length)(Random.nextDouble)
  }
}
