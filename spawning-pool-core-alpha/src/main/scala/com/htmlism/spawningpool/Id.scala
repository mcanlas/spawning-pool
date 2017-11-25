package com.htmlism.spawningpool

case class Id[A](x: A) {
  def map[B](f: A => B): Id[B] = Id(f(x))
}
