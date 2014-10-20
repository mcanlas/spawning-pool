package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class SolverSpec extends Specification {
  "The solver" should {
    import Solver._

    "select individuals at random" in {
      val rig = new DeterministicProvider[Int](Seq(0)) with RandomIndexProvider {
        def randomIndex(size: Int) = nextElement
      }

      randomIndividual(Seq('arthas))(rig) === 'arthas
    }
  }
}
