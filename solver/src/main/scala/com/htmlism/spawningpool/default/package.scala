package com.htmlism.spawningpool

import scala.util.Random

package object default {
  private val DEFAULT_ARRAY_LENGTH = 100

  private val rngInt    = () => Random.nextInt
  private val rngDouble = () => Random.nextDouble

  private val rngLength = (max: Int) => Random.nextInt(max)

  object IntGenerator extends Generator[Int] {
    def generate: Int = Random.nextInt
  }

  object DoubleGenerator extends Generator[Double] {
    def generate: Double = Random.nextDouble
  }

  object FixedIntArrayGenerator extends FixedIntArrayGenerator(DEFAULT_ARRAY_LENGTH, rngInt)
  object FixedDoubleArrayGenerator extends FixedDoubleArrayGenerator(DEFAULT_ARRAY_LENGTH, rngDouble)
  object VariableIntArrayGenerator extends VariableIntArrayGenerator(DEFAULT_ARRAY_LENGTH, rngInt, rngLength)
  object VariableDoubleArrayGenerator extends VariableDoubleArrayGenerator(DEFAULT_ARRAY_LENGTH, rngDouble, rngLength)

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
}
