package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class ChromosomeSpec extends Specification {
  "A fixed-length chromosome" should {
    val chromosome = TspTour(Seq('NewYorkCity, 'LosAngeles, 'Chicago))

    "support mutation" in {
      chromosome.mutate === TspTour(Seq('NewYorkCity, 'Boston, 'Chicago))
    }

    "support crossover" in {
      val asianTour = TspTour(Seq('HongKong, 'Tokyo, 'Beijing))

      chromosome.crossover(asianTour) === TspTour(Seq('HongKong, 'LosAngeles, 'Beijing))
    }
  }

  "A variable-length chromosome" should {
    import VariableLengthChromosome._

    "support spot mutation" in {
      val stack = StackOperations(Seq('subtract, 'divide, 'multiply), MutateGene)

      stack.mutate.genes === Seq('subtract, 'conquer, 'multiply)
    }

    "support add mutation" in {
      val stack = StackOperations(Seq('subtract, 'divide, 'multiply), AddGene)

      stack.mutate.genes === Seq('subtract, 'divide, 'multiply, 'conquer)
    }

    "support drop mutation" in {
      val stack = StackOperations(Seq('subtract, 'divide, 'multiply), RemoveGene)

      stack.mutate.genes === Seq('subtract, 'multiply)
    }

    "support crossover" in {
      val firstStack  = StackOperations(Seq('subtract, 'divide, 'multiply), MutateGene)
      val secondStack = StackOperations(Seq('power, 'log, 'conquer, 'modulus, 'root), MutateGene)

      firstStack.crossover(secondStack).genes === Seq('subtract, 'log, 'multiply, 'modulus)
    }
  }
}

case class TspTour(genes: Seq[Symbol]) extends FixedLengthChromosome[TspTour, Symbol] with CombinatorialChromosome[TspTour, Symbol] {
  private val parents = new DeterministicGenerator[Boolean](Seq(false, true, false))

  def construct(genes: Seq[Symbol]) = TspTour(genes)

  def alleles = Seq('Boston)

  override def randomAlleleIndex = 0
  override def randomGeneIndex = 1
  override def randomThisParent = parents.nextElement
}

case class StackOperations(genes: Seq[Symbol], override val randomMutationOperation: Int) extends VariableLengthChromosome[StackOperations, Symbol] with CombinatorialChromosome[StackOperations, Symbol] {
  private val parents = new DeterministicGenerator[Boolean](Seq(true, false, true, false, true))

  def alleles = Seq('conquer)

  def construct(genes: Seq[Symbol]) = StackOperations(genes, randomMutationOperation)

  override def randomAlleleIndex = 0
  override def randomGeneIndex = 1
  override def randomNewGeneIndex = 4
  override def randomThisParent = parents.nextElement
}
