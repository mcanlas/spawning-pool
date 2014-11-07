package com.htmlism.spawningpool

/**
 * A base trait for genetic operators
 *
 * @tparam A The type of the chromosome
 */

trait Evolver[A] {
  /**
   * Mutates the given chromosome
   *
   * The intent of mutation is to provide a small, random change to an existing chromosome and yield a new chromosome whose fitness is somewhat similar to the original
   *
   * @param chromosome The chromosome to mutate
   * @return A new chromosome
   */

  def mutate(chromosome: A): A

  /**
   * Combines two parent chromosomes to yield a child chromosome
   *
   * The intent of combination is to produce a chromosome whose fitness reflects the fitness of parts of its parents
   *
   * @param firstParent A parent chromosome
   * @param secondParent Another parent chromosome
   * @return A new chromosome
   */

  def crossover(firstParent: A, secondParent: A): A
}
