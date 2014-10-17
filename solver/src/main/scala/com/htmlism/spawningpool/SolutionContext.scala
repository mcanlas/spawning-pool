package com.htmlism.spawningpool

object SolutionContext {
  def apply[A, B](fitness: A => B, evolver: Evolver[A], population: Seq[A])(implicit ordering: Ordering[B]) = {
    new SolutionContext(fitness, evolver, population, 0)
  }
}

class SolutionContext[A, B](val fitness: A => B, val evolver: Evolver[A], val population: Seq[A], val generations: Int)(implicit val ordering: Ordering[B]) {
  def increment(newPopulation: Seq[A]) = new SolutionContext(fitness, evolver, newPopulation, generations + 1)
}
