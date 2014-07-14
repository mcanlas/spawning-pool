package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes backed by a sequence.
  *
  * {{{
  *   def genes: Seq[A]
  * }}}
  *
  * This trait provides a default implementation for mutation. Mutation occurs by
  * replacing a random gene with a randomly generated allele.
  *
  */

trait IndexedChromosome[A] extends HomogeneousChromosome[A] {
  /** The sequence of genes that make up this chromosome.
   *
   * @return A collection of genes
   */

  def genes: Seq[A]

  def apply(n: Int) = genes(n)

  def mutate: IndexedChromosome[A] = ??? // TODO implement spot mutation here

  def crossover(mate: Chromosome): IndexedChromosome[A] = ??? // TODO implement variable length crossover here
}
