package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification

class DiscreteAlleleGeneratorSpec extends Specification {
  "A discrete allele generator" should {
    "return the expected values" in {

      val generator = new DiscreteAlleleGenerator[Symbol] with DiscreteAlleleIndexProvider {
        private val rng = Iterable(2, 0, 1).iterator

        val alleles = Seq('alpha, 'beta, 'gamma)

        def randomDiscreteAlleleIndex(size: Int) = rng.next()
      }

      generator.generateAllele === 'gamma
      generator.generateAllele === 'alpha
      generator.generateAllele === 'beta
    }
  }
}
