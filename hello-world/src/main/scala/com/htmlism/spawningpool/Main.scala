package com.htmlism.spawningpool

object Main extends App {
  println("hello")

  val solver = new Solver(PhraseFitness.fitnessFor("hello world"))

//  solver.solveNow
}

case class Phrase(genes: Seq[Char]) extends FixedLengthChromosome[Phrase, Char] {
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

object PhraseFitness {
  def fitnessFor(target: String)(phrase: Phrase) = (for (i <- 0 to target.length - 1) yield {
    val targetInt    = target(i).toInt
    val candidateInt = phrase(i).toInt

    if (targetInt == candidateInt)
      10
    else
      -2 * Math.abs(targetInt - candidateInt)
  }).sum
}
