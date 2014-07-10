package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class SolverSpec extends Specification {
  private def fitness(symbol: Symbol) = 0

  "Given an initial population seed, the solver" should {
    "return the right solution" in {
      val solver = new Solver(fitness) : Solver[Symbol, Int] // intellij can't infer this implementation w/ a hint

      solver.solveNow(Seq('chrono, 'marle, 'lucca)) === Set('chrono, 'marle, 'lucca)
    }
  }

  "Given no initial population seed, the solver" should {
    "return solutions" in {
      val solver = new Solver(fitness, populationSize = 3, islandCount = 1)
      implicit val generator = new ChromosomeProvider('cindy, 'sanda, 'mindy)

      solver.solveNow === Set('cindy, 'sanda, 'mindy)
    }
  }
}
