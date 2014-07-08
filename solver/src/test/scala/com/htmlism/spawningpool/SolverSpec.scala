package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class SolverSpec extends Specification {
  "Given an initial population seed, the solver" should {
    "return the right solution" in {
      val solver = new Solver

      solver.solve(Seq('chrono, 'marle, 'lucca)) === Set('chrono, 'marle, 'lucca)
    }
  }

  "Given no initial population seed, the solver" should {
    "return solutions" in {
      val solver = new Solver(3)
      implicit val generator = new ChromosomeProvider('cindy, 'sanda, 'mindy)

      solver.solve === Set('cindy, 'sanda, 'mindy)
    }
  }
}
