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

  // TODO test variable length
}

case class TspTour(genes: Seq[Symbol]) extends FixedLengthChromosome[TspTour, Symbol] with CombinatorialChromosome[TspTour, Symbol] {
  private val parents = new DeterministicGenerator[Boolean](Seq(false, true, false))

  def construct(genes: Seq[Symbol]) = TspTour(genes)

  def alleles = Seq('Boston)

  override def randomAlleleIndex = 0
  override def randomGeneIndex = 1
  override def randomThisParent = parents.nextElement
}
