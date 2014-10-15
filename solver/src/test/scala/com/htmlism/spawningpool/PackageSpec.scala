package com.htmlism.spawningpool

import org.specs2.mutable.Specification

class PackageSpec extends Specification {
  "Memoization" should {
    "prevent side-effects on subsequent applications" in {
      val scratch = collection.mutable.Map[Symbol, Int]().withDefaultValue(0)

      val originalFunction = { key: Symbol =>
        scratch(key) = scratch(key) + 1
      }

      val memoizedFunction = memoize(originalFunction)

      memoizedFunction('pauper)
      scratch === Map('pauper -> 1)

      memoizedFunction('pauper)
      scratch === Map('pauper -> 1)

      originalFunction('prince)
      originalFunction('prince)
      scratch == Map('pauper -> 1, 'prince -> 2) // smart equality operator not so smart on disparate constructions?
    }
  }
}
