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
  private val DEFAULT_FIXED_ARRAY_LENGTH = 100

  implicit val intGenerator    = IntGenerator
  implicit val doubleGenerator = DoubleGenerator

  implicit val intArrayGenerator    = FixedIntArrayGenerator(DEFAULT_FIXED_ARRAY_LENGTH)
  implicit val doubleArrayGenerator = FixedDoubleArrayGenerator(DEFAULT_FIXED_ARRAY_LENGTH)
}

object IntGenerator extends Generator[Int] {
  def generate: Int = Random.nextInt
}

object DoubleGenerator extends Generator[Double] {
  def generate: Double = Random.nextDouble
}

// int array

trait IntArrayGenerator extends Generator[Array[Int]] {
  def length: Int

  def generate: Array[Int] = Array.fill(length)(Random.nextInt)
}

case class FixedIntArrayGenerator(length: Int) extends IntArrayGenerator

class VariableIntArrayGenerator(rng: LengthProvider, maximum: Int) extends IntArrayGenerator {
  def length: Int = rng.nextLength(maximum)
}

// double array

trait DoubleArrayGenerator extends Generator[Array[Double]] {
  def length: Int

  def generate: Array[Double] = Array.fill(length)(Random.nextDouble)
}

case class FixedDoubleArrayGenerator(length: Int) extends DoubleArrayGenerator

class VariableDoubleArrayGenerator(rng: LengthProvider, maximum: Int) extends DoubleArrayGenerator {
  def length: Int = rng.nextLength(maximum)
}

// length providers

trait LengthProvider {
  def nextLength(maximum: Int): Int
}

object RandomLengthProvider extends LengthProvider {
  def nextLength(maximum: Int): Int = Random.nextInt(maximum)
}
