package com.htmlism.spawningpool

object Main extends App {
  val solver = new Solver
  val seed = 1 to 10

  solver.solve(seed).foreach { println }
}
