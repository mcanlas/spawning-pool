package com.htmlism.spawningpool.fitness

import scala.annotation.nowarn

import org.specs2.mutable.Specification

@nowarn("msg=unused value")
@SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements", "org.wartremover.warts.Unused"))
class FitnessSpec extends Specification {
  "fitness by ordering" should {
    val fitness = new OrdinalFitness[(String, Int)]
    "summon the implicit ordering" in {
      fitness.compare("a" -> 1, "a" -> 2) must_== -1
      fitness.compare("a" -> 1, "a" -> 1) must_== 0
      fitness.compare("b" -> 1, "a" -> 2) must_== 1
    }
  }

  "ratio fitness" should {
    val fitness = new RatioFitness((s: String) => s.length)
    "summon the implicit numeric" in {
      fitness.compare("short", "longest") must_== -1
      fitness.compare("equal", "apple") must_== 0
      fitness.compare("longest", "short") must_== 1
    }
  }

  "fitness" should {
    val fitness = new OrdinalFitness[Int]
    "support minimization" in {
      fitness.compare(123, 45) must_== 1
      fitness.minimize.compare(123, 45) must_== -1
    }

    "support chaining" in {
      val fitness1     = new OrdinalFitness[Int]
      val fitness2     = new OrdinalFitness[Double]
      val totalFitness = fitness1 andThen fitness2
      totalFitness.compare((1, 1d), (1, 2d)) must_== -1
    }
  }
}
