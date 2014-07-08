package com.htmlism.spawningpool

object Main extends App {
  implicit object IntegerGenerator extends Generator[Int] {
    def generate = (new util.Random).nextInt()
  }

  val solver = new Solver
  val seed = 1 to 10

  println("seeds given")
  solver.solve(seed).foreach { println }

  println()
  println("seeds not given")
  solver.solve.foreach { println }
}
