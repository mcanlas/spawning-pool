package com.htmlism.spawningpool.fitness

/**
  * A typeclass for describing fitness for some type of solution
  *
  * @tparam A The solution type whose fitness is being evaluated
  */
trait OrdinalFitness[A] {
  /**
    * Given two solutions, find out how they relate.
    *
    * - negative if x is less than (worse than) y
    * - positive if x is greater than (better than) y
    * - zero if x equals y
    *
    * @param x The first solution
    * @param y The second solution
    * @return An integer
    */
  def compare(x: A, y: A): Int
}

/**
  * Fitness that is satisfied using an implicit ordering in the solution space. Scala already provides ordering for
  * common types like `Int` and `Double` as well as tuples of those types
  *
  * @tparam A The solution type whose fitness is being evaluated
  */
class FitnessByOrdering[A : Ordering] extends OrdinalFitness[A] {
  def compare(x: A, y: A): Int = implicitly[Ordering[A]].compare(x, y)
}

/**
  * Fitness that is satisfied using a fitness evaluation function and an implicit numeric for the fitness score.
  *
  * This is the most common way to provide fitness to a genetic algorithm.
  *
  * @param f A function for converting a solution to a fitness score. This score type must support numeric operations.
  *          Scala already provides numeric support for common types like `Int` and `Double`
  * @tparam A The solution type whose fitness is being evaluated
  * @tparam B A numeric type for scoring
  */
class RatioFitness[A, B : Numeric](f: A => B) extends OrdinalFitness[A] {
  def compare(x: A, y: A): Int = implicitly[Numeric[B]].compare(f(x), f(y))
}
