package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes of variable length.
  *
  * This trait augments the default mutation operator specified by [[IndexedChromosome]]
  * with two other alternatives. Mutation occurs by randomly choosing one of these three
  * operations:
  *
  *  - Add a randomly generated gene in a random location
  *  - Delete a random gene
  *  - Mutate a random gene (via [[IndexedChromosome]])
  *
  * */

trait VariableLengthChromosome[A] extends IndexedChromosome[A] {
  override def mutate: VariableLengthChromosome[A] = {
    // TODO given rig, choose add in n + 1, delete in n, or spot mutate

    ???
  }
}
