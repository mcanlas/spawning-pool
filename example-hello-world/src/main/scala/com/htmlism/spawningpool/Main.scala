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

object CombinatorialPhraseGenerator
  extends FixedLengthCombinator[Char]
  with AlleleGenerator[Char]
  with DefaultRandomProvider {
  private val rng = new util.Random

  val size = 11

  def generateAllele = rng.nextInt(256).toChar
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
