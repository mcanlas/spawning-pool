package com.htmlism.spawningpool

/** The base trait for chromosomes that support mutation and crossover.
  *
  * {{{
  *   def mutate: Chromosome
  *
  *   def crossover(mate: Chromosome): Chromosome
  * }}}
  *
  * @tparam A The trait or class extending this trait
  *
  */

trait Chromosome[A] {
  /** Produces a slightly modified chromosome.
    *
    * @return A chromosome
    */

  def mutate: A

  /** Produces a child chromosome given a mate. The child chromosome reflects
    * characteristics of both parent chromosomes.
    *
    * @param mate A chromosome with which to mate
    * @return A child chromosome
    */

  def crossover(mate: A): A
}
