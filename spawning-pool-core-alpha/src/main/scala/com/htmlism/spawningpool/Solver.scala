package com.htmlism.spawningpool

import scala.concurrent.Future

trait Solver[A, F[_]] {
  def solve: F[A]
}

class EvolutionarySolver[A : Generation : Evolution] extends Solver[A, Future] {
  def solve: Future[A] = Future(??? : A)
}
