package com.htmlism.spawningpool

/** The base trait for chromosomes that support mutation and crossover. */

trait Chromosome {
  def mutate: Chromosome

  def crossover(mate: Chromosome): Chromosome
}
