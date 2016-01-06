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
  private val DEFAULT_ARRAY_LENGTH = 100

  private val rngInt    = () => Random.nextInt
  private val rngDouble = () => Random.nextDouble

  implicit val intGenerator:    Generator[Int]    = IntGenerator
  implicit val doubleGenerator: Generator[Double] = DoubleGenerator

  implicit val intArrayGenerator:    Generator[Array[Int]]    = new FixedIntArrayGenerator(DEFAULT_ARRAY_LENGTH, rngInt)
  implicit val doubleArrayGenerator: Generator[Array[Double]] = new FixedDoubleArrayGenerator(DEFAULT_ARRAY_LENGTH, rngDouble)

  object VariableLength {
    private val rngLength = (max: Int) => Random.nextInt(max)

    implicit val intArrayGenerator:    Generator[Array[Int]]    = new VariableIntArrayGenerator(DEFAULT_ARRAY_LENGTH, rngInt, rngLength)
    implicit val doubleArrayGenerator: Generator[Array[Double]] = new VariableDoubleArrayGenerator(DEFAULT_ARRAY_LENGTH, rngDouble, rngLength)
  }
}

object IntGenerator extends Generator[Int] {
  def generate: Int = Random.nextInt
}

object DoubleGenerator extends Generator[Double] {
  def generate: Double = Random.nextDouble
}

// fixed

class FixedIntArrayGenerator(length: Int, nextGene: () => Int) extends Generator[Array[Int]] {
  def generate: Array[Int] = Array.fill(length)(nextGene.apply)
}

class FixedDoubleArrayGenerator(length: Int, nextGene: () => Double) extends Generator[Array[Double]] {
  def generate: Array[Double] = Array.fill(length)(nextGene.apply)
}

// variable

class VariableIntArrayGenerator(max: Int, nextGene: () => Int, nextLength: Int => Int) extends Generator[Array[Int]] {
  def generate: Array[Int] = Array.fill(nextLength(max))(nextGene.apply)
}

class VariableDoubleArrayGenerator(max: Int, nextGene: () => Double, nextLength: Int => Int) extends Generator[Array[Double]] {
  def generate: Array[Double] = Array.fill(nextLength(max))(nextGene.apply)
}
