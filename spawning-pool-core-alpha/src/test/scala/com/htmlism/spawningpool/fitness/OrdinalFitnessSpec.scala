package com.htmlism.spawningpool.fitness

import org.specs2.mutable.Specification

class OrdinalFitnessSpec extends Specification {
  "ratio fitness" should {
    "summon the implicit numeric" in {
      val fitness = new RatioFitness((s: String) => s.length)

      fitness.compare("short",   "longest") === -1
      fitness.compare("equal",   "apple")   ===  0
      fitness.compare("longest", "short")   ===  1
    }
  }
}
