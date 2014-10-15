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
      implicit val generator = new ChromosomeProvider('cindy, 'sandy, 'mindy)

      solver.solveNow === Set('cindy, 'sandy, 'mindy)
    }
  }

  "Having multiple islands" should {
    "affect the results"  in {
      val solver = new Solver(fitness, populationSize = 1, islandCount = 3)
      implicit val generator = new ChromosomeProvider('cecil, 'rosa, 'kain)

      solver.solveNow === Set('cecil, 'rosa, 'kain)
    }
  }

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
