package com.htmlism.spawningpool

object SolutionContext {
  def apply[A, B](fitness: A => B, population: Seq[A])(implicit ordering: Ordering[B]) = {
    new SolutionContext(memoize(fitness), population)
  }
}

class SolutionContext[A, B](val fitness: A => B, val population: Seq[A])(implicit val ordering: Ordering[B]) {
  def withPopulation(newPopulation: Seq[A]) = new SolutionContext(fitness, newPopulation)
}
