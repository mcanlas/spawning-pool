package com.htmlism.spawningpool.fitness

import org.specs2.mutable.Specification

class FitnessSpec extends Specification {
  "fitness by ordering" should {
    "summon the implicit ordering" in  {
      val fitness = new OrdinalFitness[(String, Int)]

      fitness.compare("a" -> 1, "a" -> 2) === -1
      fitness.compare("a" -> 1, "a" -> 1) ===  0
      fitness.compare("b" -> 1, "a" -> 2) ===  1
    }
  }

  "ratio fitness" should {
    "summon the implicit numeric" in {
      val fitness = new RatioFitness((s: String) => s.length)

      fitness.compare("short",   "longest") === -1
      fitness.compare("equal",   "apple")   ===  0
      fitness.compare("longest", "short")   ===  1
    }
  }

  "fitness" should {
    "support minimization" in {
      val fitness = new OrdinalFitness[Int]

      fitness.compare(123, 45) === 1
      fitness.minimize.compare(123, 45) === -1
    }

    "support chaining" in {
      val fitness1 = new OrdinalFitness[Int]
      val fitness2 = new OrdinalFitness[Double]
      val totalFitness = fitness1 andThen fitness2

      totalFitness.compare((1, 1d), (1, 2d)) === -1
    }
  }
}
