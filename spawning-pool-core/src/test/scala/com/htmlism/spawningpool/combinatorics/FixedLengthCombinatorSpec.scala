package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class FixedLengthCombinatorSpec extends Specification {
  "A fixed-length combinator" should {
    val size = 3

    val combinator = new FixedTestCombinator(size)

    val firstChromosome = combinator.generateChromosome
    val secondChromosome = combinator.generateChromosome

    val mutatedChromosome = combinator.mutate(firstChromosome)

    "generate chromosomes of a fixed length" in {
      firstChromosome.length === size
      secondChromosome.length === size
    }

    "generate the expected values" in {
      firstChromosome === Seq('luigi, 'bowser, 'peach)
      secondChromosome === Seq('mario, 'luigi, 'bowser)
    }

    "support spot mutation" in {
      mutatedChromosome === Seq('luigi, 'mario, 'peach)
    }

    "support crossover" in {
      combinator.crossover(firstChromosome, secondChromosome) === Seq('mario, 'luigi, 'peach)
    }
  }
}

class FixedTestCombinator(val size: Int) extends FixedLengthCombinator[Symbol] with DiscreteAlleleGenerator[Symbol] {
  private val alleleIndexes = Iterable(1, 3, 2, 0, 1, 3, 0).iterator
  private val parents = Iterable(false, false, true).iterator

  def alleles: Seq[Symbol] = Seq('mario, 'luigi, 'peach, 'bowser)

  def nextAlleleIndex(size: Int) = alleleIndexes.next()

  def nextGeneIndex(unused: Int) = 1

  def nextUseFirstParent = parents.next()

  override def fill(unused: Int) = List.fill(size)
}
