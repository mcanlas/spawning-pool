package com.htmlism.spawningpool

object Solver {
  val defaultPopulationSize: Int = 1000

  val defaultNumberOfIslands: Int = 5
}

trait Solver[A, F[_]] {
  def populationSize: Int

  def solve: F[A]
}

// Single Population solver
// island solver

class EvolutionarySolverGeneric[A : Generation, F[_] : Monad](
  populationSize: Int = Solver.defaultPopulationSize,
  numberOfIslands: Int = Solver.defaultNumberOfIslands,

  ) extends Solver[A, F] {
  private val monad = implicitly[Monad[F]]
  private val gen = implicitly[Generation[A]]

  def solve: F[A] = monad(??? : A)
}
