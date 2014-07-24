package com.htmlism.spawningpool

object Main extends App {
  println("hello")
}

class Phrase(val genes: Seq[Char]) extends FixedLengthChromosome[Phrase, Char] {
  /** Generates an allele.
    *
    * This method provides a source of values for genes during mutation.
    *
    * @return An allele.
    */
  def generateAllele = (new util.Random).nextInt(Char.MaxValue.toInt).toChar

  /** A constructor for chromosomes of this type.
    *
    * @param genes The genes of the new chromosome
    * @return A new chromosome
    */
  def construct(genes: Seq[Char]) = new Phrase(genes)
}
