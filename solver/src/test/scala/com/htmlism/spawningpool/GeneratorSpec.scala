package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class GeneratorSpec extends Specification {
  "Generation" should {
    "provide default implementations" in {
      findGenerator[Int].generate
      findGenerator[Double].generate
      findGenerator[Array[Int]].generate
      findGenerator[Array[Double]].generate

      true
    }
  }

  private def findGenerator[A](implicit generator: Generator[A]) = generator
}
