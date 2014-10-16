package com.htmlism.spawningpool

trait Evolver[A] {
  def mutate(chromosome: A): A

  def crossover(firstParent: A, secondParent: A): A
}
