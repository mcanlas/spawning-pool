package com.htmlism.spawningpool.fitness

/**
  * @tparam A The element type whose fitness is being evaluated
  */
trait OrdinalFitness[A] {
  def compare(x: A, y: A): Int
}

class FitnessByOrdering[A : Ordering] extends OrdinalFitness[A] {
  def compare(x: A, y: A): Int = ???
}

class RatioFitness[A, B : Numeric](f: A => B) extends OrdinalFitness[A] {
  def compare(x: A, y: A): Int = implicitly[Numeric[B]].compare(f(x), f(y))
}
