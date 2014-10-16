package com.htmlism.spawningpool

object SolutionContext {
  def apply[A, B](fitness: A => B, ordering: Ordering[B], population: Seq[A]) = {
    new SolutionContext(memoize(fitness), ordering, population)
  }
}

class SolutionContext[A, B](val fitness: A => B, val ordering: Ordering[B], val population: Seq[A]) {
  def withPopulation(newPopulation: Seq[A]) = new SolutionContext(fitness, ordering, newPopulation)
}
