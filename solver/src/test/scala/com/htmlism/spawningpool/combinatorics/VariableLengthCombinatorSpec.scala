package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class VariableLengthCombinatorSpec extends Specification {
  "A variable-length generator" should {
    val combinator = new VariableTestCombinator

    val firstChromosome  = combinator.generateChromosome
    val secondChromosome = combinator.generateChromosome
    val thirdChromosome  = combinator.generateChromosome

    lazy val firstMutation   = combinator.mutate(firstChromosome)
    lazy val secondMutation  = combinator.mutate(firstChromosome)
    lazy val thirdtMutation  = combinator.mutate(firstChromosome)

    "generate chromosomes of differing lengths" in {
      firstChromosome.length  === 1
      secondChromosome.length === 3
      thirdChromosome.length  === 5
    }

    "generate chromosomes of the provided alleles" in {
      firstChromosome  === Seq('GoGo)
      secondChromosome === Seq('HoneyLemon, 'Baymax, 'Fred)
      thirdChromosome  === Seq('Hiro, 'Wasabi, 'GoGo, 'Baymax, 'HoneyLemon)
    }
  }
}

class VariableTestCombinator
  extends VariableLengthCombinator[Symbol]
  with DiscreteAlleleGenerator[Symbol] {
  val maximumSize = 11
  val alleles = Seq('Hiro, 'Baymax, 'Fred, 'GoGo, 'Wasabi, 'HoneyLemon)

  private val mutationMethods = Iterable(2, 0, 1).iterator
  def nextMutationMethod: Int = mutationMethods.next()

  private val alleleIndexes = Iterable(3, 5, 1, 2, 0, 4, 3, 1, 5).iterator
  def nextAlleleIndex(size: Int) = alleleIndexes.next()

  def nextUseFirstParent: Boolean = ???

  def nextGeneIndex(size: Int): Int = ???

  private val lengths = Iterable(1, 3, 5).iterator
  def nextLength(maximum: Int) = lengths.next()

  // variation
  def nextGeneIndexForInsertion(size: Int): Int = 0
  def nextGeneIndexForRemoval(size: Int): Int = 0
}
