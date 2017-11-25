package com.htmlism.spawningpool.generation

object Generation {
  implicit val intGeneration: Generation[Int] = null
}

trait Generation[A] {
}
