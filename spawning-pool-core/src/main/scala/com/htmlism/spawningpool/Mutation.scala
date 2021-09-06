package com.htmlism.spawningpool

import scala.annotation.implicitNotFound

/**
  * A typeclass that represents a unary mutation operation for a chromosome.
  *
  * @tparam A
  *   The type of the chromosome
  */

@implicitNotFound("Please define mutation support for type ${A}")
trait Mutation[A] {

  /**
    * Returns a mutated version of a chromosome.
    *
    * @param x
    *   A chromosome
    *
    * @return
    *   A chromosome
    */
  def mutate(x: A): A
}

object IntMutation extends Mutation[Int] {
  def mutate(x: Int): Int = x + 1
}

object DoubleMutation extends Mutation[Double] {
  def mutate(x: Double): Double = ???
}

object FixedArrayIntMutation extends Mutation[Array[Int]] {
  def mutate(x: Array[Int]): Array[Int] = ???
}

object FixedDoubleMutation extends Mutation[Array[Double]] {
  def mutate(x: Array[Double]): Array[Double] = ???
}
