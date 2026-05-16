package com.htmlism.spawningpool

import scala.annotation.nowarn

import org.specs2.mutable.Specification

import com.htmlism.spawningpool.Solver.randomIndividual

@nowarn("msg=unused value")
@SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements", "org.wartremover.warts.Unused"))
class SolverSpec extends Specification {
  "The solver" should {
    "select individuals at random" in {
      val rig = new RandomIndexProvider {
        val iterator = Iterable(0).iterator

        def randomIndex(size: Int) = iterator.next()
      }

      randomIndividual(Seq("arthas"))(rig) === "arthas"
    }
  }
}
