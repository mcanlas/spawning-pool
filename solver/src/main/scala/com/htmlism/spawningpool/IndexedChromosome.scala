package com.htmlism.spawningpool

/** The base trait for homogeneous chromosomes backed by a sequence.
  *
  * {{{
  *   def genes: Seq[A]
  *
  *   def construct(genes: Seq[A]): IndexedChromosome[A]
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

  /** A constructor for chromosomes of this type.
    *
    * @param genes The genes of the new chromosome
    * @return A new chromosome
    */

  def construct(genes: Seq[A]): IndexedChromosome[A]

  /** A gene at index n of the chromosome
    *
    * @param n The index of the gene
    * @return A gene
    */

  def apply(n: Int) = genes(n)

  def mutate: IndexedChromosome[A] = construct(genes.updated(randomGeneIndex, generateAllele))

  def crossover(mate: Chromosome): IndexedChromosome[A] = ??? // TODO implement variable length crossover here

  def randomGeneIndex = new util.Random().nextInt(genes.size)
}
