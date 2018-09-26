package com.htmlism.spawningpool.fitness

/**
  * A typeclass for describing fitness for some type of solution
  *
  * @tparam A The solution type whose fitness is being evaluated
  */
trait Fitness[A] {
  self =>

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

  def minimize: Fitness[A] = new Fitness[A] {
    def compare(x: A, y: A) = self.compare(x, y) * -1
  }

  def andThen[B](that: Fitness[B]): Fitness[(A, B)] = new Fitness[(A, B)] {
    def compare(x: (A, B), y: (A, B)): Int = {
      val score = self.compare(x._1, y._1)

      if (score == 0)
        that.compare(x._2, y._2)
      else
        score
    }
  }
}

/**
  * Fitness that is satisfied using an implicit ordering in the solution space. Scala already provides ordering for
  * common types like `Int` and `Double` as well as tuples of those types
  *
  * @tparam A The solution type whose fitness is being evaluated
  */
class OrdinalFitness[A: Ordering] extends Fitness[A] {
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
class RatioFitness[A, B: Numeric](f: A => B) extends Fitness[A] {
  def compare(x: A, y: A): Int = implicitly[Numeric[B]].compare(f(x), f(y))
}
