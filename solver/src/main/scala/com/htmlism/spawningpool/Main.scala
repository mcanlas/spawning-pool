package com.htmlism.spawningpool

object Main extends App {
  val solver = new Solver

  solver.solve.foreach { println }
}
