package com.htmlism.spawningpool

object SolutionContext {
  def apply[A, B](id: Int, fitness: A => B, evolver: Evolver[A], population: Seq[A])(implicit ordering: Ordering[B]): SolutionContext[A, B] = {
    new SolutionContext(id, memoize(fitness), evolver, population, 0)
  }
}

case class SolutionContext[A, B](islandId: Int, fitness: A => B, evolver: Evolver[A], population: Seq[A], generations: Int)(implicit val ordering: Ordering[B]) {
  def increment(newPopulation: Seq[A]): SolutionContext[A, B] = copy(population = newPopulation, generations = generations + 1)
}
