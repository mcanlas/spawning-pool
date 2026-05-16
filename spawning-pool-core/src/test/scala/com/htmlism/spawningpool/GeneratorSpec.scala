package com.htmlism.spawningpool

import scala.annotation.nowarn

import org.specs2.mutable.Specification

@nowarn("msg=unused value")
@SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements", "org.wartremover.warts.Unused"))
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
