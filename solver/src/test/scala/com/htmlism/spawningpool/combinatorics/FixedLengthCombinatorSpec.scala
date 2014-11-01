package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class FixedLengthCombinatorSpec extends Specification {
  "A fixed-length generator" should {
    val size = 3

    val generator = new FixedTestCombinator(size)

    val firstChromosome  = generator.generateChromosome
    val secondChromosome = generator.generateChromosome

    "generate chromosomes of a fixed length" in {
      firstChromosome.length  === size
      secondChromosome.length === size
    }

    "generate the expected values" in {
      firstChromosome  === Seq('luigi, 'bowser, 'peach)
      secondChromosome === Seq('mario, 'luigi, 'bowser)
    }
  }
}

class FixedTestCombinator(val size: Int)
  extends FixedLengthCombinator[Symbol]
  with DiscreteAlleleGenerator[Symbol] {
  private val alleleIndexes = Iterable(1, 3, 2, 0, 1, 3).iterator

  def alleles: Seq[Symbol] = Seq('mario, 'luigi, 'peach, 'bowser)

  def randomDiscreteAlleleIndex(size: Int) = alleleIndexes.next()

  override def fill(size: Int) = List.fill(size)
}