package com.htmlism.spawningpool.combinatorics

import org.specs2.mutable.Specification
import com.htmlism.spawningpool.DeterministicProvider

class DiscreteAlleleGeneratorSpec extends Specification {
  "A discrete allele generator" should {
    "return the expected values" in {

      val generator = new DiscreteAlleleGenerator[Symbol] with DiscreteAlleleIndexProvider {
        private val rng = DeterministicProvider(2, 0, 1)

        val alleles = Seq('alpha, 'beta, 'gamma)

        def randomDiscreteAlleleIndex(size: Int) = rng.nextElement
      }

      generator.generateAllele === 'gamma
      generator.generateAllele === 'alpha
      generator.generateAllele === 'beta
    }
  }
}
