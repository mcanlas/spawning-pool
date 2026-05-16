package com.htmlism.spawningpool.combinatorics

import scala.annotation.nowarn

import org.specs2.mutable.Specification

@nowarn("msg=unused value")
@SuppressWarnings(
  Array("org.wartremover.warts.NonUnitStatements", "org.wartremover.warts.Product", "org.wartremover.warts.Unused")
)
class DiscreteAlleleGeneratorSpec extends Specification {
  "A discrete allele generator" should {
    "return the expected values" in {

      val generator = new DiscreteAlleleGenerator[String] with AlleleIndexProvider {
        private val rng = Iterable(2, 0, 1).iterator

        val alleles = Seq("alpha", "beta", "gamma")

        def nextAlleleIndex(size: Int) = rng.next()
      }

      generator.generateAllele === "gamma"
      generator.generateAllele === "alpha"
      generator.generateAllele === "beta"
    }
  }
}
