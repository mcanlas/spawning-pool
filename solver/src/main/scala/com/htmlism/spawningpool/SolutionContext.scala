package com.htmlism.spawningpool

object SolutionContext  {
  /**
   * A factory method for solution contexts
   *
   * @param islandId A nominal identifier
   * @param fitness A fitness function
   * @param evolver An evolver for solutions
   * @param mutationRate The rate of mutation from 0 to 1
   * @param population A collection of solutions
   * @param ordering An ordering for fitness
   *
   * @tparam A The type of candidate solutions
   * @tparam B The type of fitness score
   *
   * @return A solution context
   */
  def apply[A, B](
    islandId: Int,
    fitness: A => B,
    evolver: Evolver[A],
    mutationRate: Double,
    population: Seq[A])(implicit ordering: Ordering[B]): SolutionContext[A, B] = {
    new SolutionContext(islandId, fitness, evolver, mutationRate, population, 0)
  }
}

/**
 * A bundle of parameters and values for evolution
 *
 * @param islandId A nominal identifier
 * @param fitness A fitness function
 * @param evolver An evolver for solutions
 * @param mutationRate The rate of mutation from 0 to 1
 * @param population A collection of solutions
 * @param generations A zero-based ordinal for generations
 * @param ordering An ordering for fitness
 * @tparam A The type of candidate solutions
 * @tparam B The type of fitness score
 */

case class SolutionContext[A, B](
  islandId: Int,
  fitness: A => B,
  evolver: Evolver[A],
  mutationRate: Double,
  population: Seq[A],
  generations: Int)(implicit val ordering: Ordering[B]) {
  def increment(newPopulation: Seq[A]): SolutionContext[A, B] = copy(
    population  = newPopulation,
    generations = generations + 1)
}
