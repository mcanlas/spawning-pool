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
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  */

trait VariableLengthChromosome[A, B] extends IndexedChromosome[A, B] {
  import VariableLengthChromosome._

  override def mutate: A = randomMutationOperation match { // TODO given rig, choose add in n + 1, delete in n, or spot mutate
    case MutateGene => super.mutate
    case AddGene    => ???
    case RemoveGene => ???
  }

  def randomMutationOperation = new util.Random().nextInt(3)
}

object VariableLengthChromosome {
  val MutateGene = 0
  val AddGene    = 1
  val RemoveGene = 2
}
