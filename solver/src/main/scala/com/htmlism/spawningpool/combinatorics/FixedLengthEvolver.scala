package com.htmlism.spawningpool.combinatorics

import com.htmlism.spawningpool.Evolver

class FixedLengthEvolver[A <: FixedLengthChromosome[A, _]] extends Evolver[A] {
  def mutate(chromosome: A) = ???

  def crossover(firstParent: A, secondParent: A) = ???
}
