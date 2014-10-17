package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class SolverSpec extends Specification {
  "The solver" should {
    import Solver._

    "select individuals at random" in {
      val rig = new DeterministicGenerator[Int](Seq(0)) with RandomIndexGenerator {
        def randomIndex(size: Int) = nextElement
      }

      randomIndividual(Seq('arthas))(rig) === 'arthas
    }
  }
}
