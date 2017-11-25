package com.htmlism.spawningpool

import scala.concurrent._

object Monad {
  implicit def futureMonad(implicit ec: ExecutionContext): Monad[Future] = new Monad[Future] {
    def apply[A](x: A): Future[A] = Future(x)

    def map[A, B](x: Future[A], f: A => B): Future[B] = x.map(f)
  }

  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def apply[A](x: A): Id[A] = Id(x)

    def map[A, B](x: Id[A], f: A => B): Id[B] = x.map(f)
  }
}

/**
  * A lightweight abstraction for computation contexts
  * @tparam M
  */
trait Monad[M[_]] {
  /**
    * A factory method.
    * @param x A value to wrap
    * @tparam A The type of the value
    * @return A value within a context
    */
  def apply[A](x: A): M[A]

  /**
    * A way to apply a function to a context.
    * @param x Some wrapped value
    * @param f A function to convert `A` to `B`
    * @tparam A The inner type of the wrapped value
    * @tparam B The return type of the function
    * @return A value within a context
    */
  def map[A, B](x: M[A], f: A => B): M[B]
}
