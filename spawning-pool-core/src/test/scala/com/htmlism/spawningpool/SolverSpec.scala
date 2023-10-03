package com.htmlism.spawningpool

import org.specs2.mutable.Specification

import com.htmlism.spawningpool.Solver.*

class SolverSpec extends Specification {
  "The solver" should {
    "select individuals at random" in {
      val rig = new RandomIndexProvider {
        val iterator = Iterable(0).iterator

        def randomIndex(size: Int) = iterator.next()
      }

      randomIndividual(Seq('arthas))(rig) === 'arthas
    }
  }
}
