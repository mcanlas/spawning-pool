package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class VariableLengthCombinatorSpec extends Specification {
  "A variable-length generator" should {
    val combinator = new VariableTestCombinator

    val firstChromosome  = combinator.generateChromosome
    val secondChromosome = combinator.generateChromosome
    val thirdChromosome  = combinator.generateChromosome

    val firstMutation  = combinator.mutate(firstChromosome)
    val secondMutation = combinator.mutate(secondChromosome)
    val thirdMutation  = combinator.mutate(thirdChromosome)

    val child = combinator.crossover(secondChromosome, firstChromosome)

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

    "support spot mutation" in {
      secondMutation === Seq('HoneyLemon, 'Hiro, 'Fred)
    }

    "support insertion mutation" in {
      thirdMutation === Seq('Wasabi, 'Hiro, 'Wasabi, 'GoGo, 'Baymax, 'HoneyLemon)
    }

    "support removal mutation" in {
      firstMutation === Seq.empty
    }

    "support crossover" in {
      child === Seq('GoGo, 'Fred)
    }
  }
}

class VariableTestCombinator
  extends VariableLengthCombinator[Symbol]
  with DiscreteAlleleGenerator[Symbol] {
  val initialSize = 11
  val alleles = Seq('Hiro, 'Baymax, 'Fred, 'GoGo, 'Wasabi, 'HoneyLemon)

  private val mutationMethods = Iterable(RemoveGene, MutateGene, AddGene).iterator
  def nextMutationMethod: MutationMethod = mutationMethods.next()

  private val alleleIndexes = Iterable(3, 5, 1, 2, 0, 4, 3, 1, 5, 0, 4).iterator
  def nextAlleleIndex(size: Int) = alleleIndexes.next()

  private val parents = Iterable(false, false, true).iterator
  def nextUseFirstParent: Boolean = parents.next()

  def nextGeneIndex(size: Int): Int = 1

  private val lengths = Iterable(1, 3, 5).iterator
  def nextLength(maximum: Int) = lengths.next()

  // variation
  def nextGeneIndexForInsertion(size: Int): Int = 0
  def nextGeneIndexForRemoval(size: Int): Int = 0
}
