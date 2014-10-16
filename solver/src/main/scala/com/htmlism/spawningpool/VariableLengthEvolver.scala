package com.htmlism.spawningpool

class VariableLengthEvolver[A <: VariableLengthChromosome[A, _]] extends Evolver[A] {
  def mutate(chromosome: A) = ???

  def crossover(firstParent: A, secondParent: A) = ???
}
