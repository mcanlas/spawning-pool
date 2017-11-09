package com.htmlism.spawningpool

import scala.concurrent.{ExecutionContext, Future}

trait Solver[A, F[_]] {
  def solve: F[A]
}

// Single Population solver
// island solver

class EvolutionarySolver[A : Generation : Evolution](implicit ec: ExecutionContext) extends Solver[A, Future] {
  def solve: Future[A] = Future(??? : A)
}
