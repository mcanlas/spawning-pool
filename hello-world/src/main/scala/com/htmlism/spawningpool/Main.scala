package com.htmlism.spawningpool

object Main extends App {
  println("hello")

  implicit val generator = PhraseGenerator

  val solver = new Solver(PhraseFitness.fitnessFor("hello world"), PhraseEvolver)

  val solutions = solver.solveNow

  solutions.foreach(println)
}

object PhraseGenerator extends ChromosomeGenerator[Phrase] {
  def generateChromosome = Phrase(Seq.fill(11)((new util.Random).nextPrintableChar()))
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

object PhraseEvolver extends Evolver[Phrase] {
  def mutate(chromosome: Phrase) = chromosome

  def crossover(firstParent: Phrase, secondParent: Phrase) = firstParent
}
