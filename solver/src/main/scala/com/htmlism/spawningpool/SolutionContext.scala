package com.htmlism.spawningpool

object SolutionContext {
  def apply[A, B](id: Int, fitness: A => B, evolver: Evolver[A], population: Seq[A])(implicit ordering: Ordering[B]): SolutionContext[A, B] = {
    new SolutionContext(id, memoize(fitness), evolver, population, 0)
  }
}

class SolutionContext[A, B](val islandId: Int, val fitness: A => B, val evolver: Evolver[A], val population: Seq[A], val generations: Int)(implicit val ordering: Ordering[B]) {
  def increment(newPopulation: Seq[A]) = new SolutionContext(islandId, fitness, evolver, newPopulation, generations + 1): SolutionContext[A, B]
}
