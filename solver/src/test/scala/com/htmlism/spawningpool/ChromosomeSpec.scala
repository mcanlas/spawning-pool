package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class ChromosomeSpec extends Specification {
  "A fixed-length chromosome" should {
    val chromosome = TspTour(Seq('NewYorkCity, 'LosAngeles, 'Chicago))

    "support mutation" in {
      chromosome.mutate === TspTour(Seq('NewYorkCity, 'Boston, 'Chicago))
    }
  }
}

case class TspTour(genes: Seq[Symbol]) extends FixedLengthChromosome[TspTour, Symbol] with CombinatorialChromosome[TspTour, Symbol] {
  def construct(genes: Seq[Symbol]) = TspTour(genes)

  def alleles = Seq('Boston)

  override def randomAlleleIndex = 0
  override def randomGeneIndex = 1
}
