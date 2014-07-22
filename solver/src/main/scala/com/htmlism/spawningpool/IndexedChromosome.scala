package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes backed by a sequence.
  *
  * {{{
  *   def genes: Seq[B]
  *
  *   def construct(genes: Seq[B]): A
  * }}}
  *
  * This trait provides a default implementation for mutation. Mutation occurs by
  * replacing a random gene with a randomly generated allele.
  *
  * @tparam A The trait or class extending this trait
  * @tparam B The type for a single gene
  *
  */

trait IndexedChromosome[A, B] extends HomogeneousChromosome[A, B] {
  /** The sequence of genes that make up this chromosome.
    *
    * @return A collection of genes
    */

  def genes: Seq[B]

  /** A constructor for chromosomes of this type.
    *
    * @param genes The genes of the new chromosome
    * @return A new chromosome
    */

  def construct(genes: Seq[B]): A

  /** A gene at index n of the chromosome
    *
    * @param n The index of the gene
    * @return A gene
    */

  def apply(n: Int) = genes(n)

  def mutate = construct(genes.updated(randomGeneIndex, generateAllele))

  def crossover(mate: A) = ??? : A // TODO implement variable length crossover here

  def randomThisParent: Boolean = ??? // TODO implement crossover parent picker

  def randomGeneIndex = new util.Random().nextInt(genes.size)
}
