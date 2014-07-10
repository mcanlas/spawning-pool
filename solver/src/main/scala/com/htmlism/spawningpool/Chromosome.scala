package com.htmlism.spawningpool

trait Chromosome {
  def mutate: Chromosome

  def crossover(mate: Chromosome): Chromosome
}
