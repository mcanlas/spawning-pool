package com.htmlism.spawningpool

import scala.concurrent.ExecutionContext.Implicits.global

import com.htmlism.spawningpool.combinatorics._

object Main extends App {
  implicit val generator = CombinatorialPhraseGenerator

  val solver = new Solver(PhraseFitness.fitnessFor("hello world"), CombinatorialPhraseGenerator, 5000, 10)

  val before = System.currentTimeMillis()
  val solutions = solver.solveNow
  val after = System.currentTimeMillis()

  println(s"evolution took ${after - before} milliseconds")

  solutions.foreach(println)
}

object PhraseGenerator extends ChromosomeGenerator[Phrase] {
  private val rng = new util.Random

  def generateChromosome = Phrase(Seq.fill(11)(rng.nextInt(256).toChar))
}

object CombinatorialPhraseGenerator
  extends FixedLengthCombinator[Char]
  with AlleleGenerator[Char]
  with DefaultRandomProvider {
  private val rng = new util.Random

  val size = 11

  def generateAllele = rng.nextInt(256).toChar
}

case class Phrase(genes: Seq[Char]) extends FixedLengthChromosome[Phrase, Char] {
  private val rng = new util.Random

  /** Generates an allele.
    *
    * This method provides a source of values for genes during mutation.
    *
    * @return An allele.
    */
  def generateAllele = rng.nextInt(256).toChar

  /** A constructor for chromosomes of this type.
    *
    * @param genes The genes of the new chromosome
    * @return A new chromosome
    */
  def construct(genes: Seq[Char]) = new Phrase(genes)
}

object PhraseFitness {
  def fitnessFor(target: String)(phrase: Seq[Char]) = (for (i <- 0 to target.length - 1) yield {
    val targetInt    = target(i).toInt
    val candidateInt = phrase(i).toInt

    if (targetInt == candidateInt)
      10
    else
      -2 * Math.abs(targetInt - candidateInt)
  }).sum
}

object PhraseEvolver extends Evolver[Phrase] {
  def mutate(chromosome: Phrase) = chromosome.mutate

  def crossover(firstParent: Phrase, secondParent: Phrase) = firstParent.crossover(secondParent)
}
