* use fs2
* describe a population to population evolver
  * mutation + crossover is slightly prescriptive
* callbacks for islands/aggregation
* case class vs Ints/better primitives
* array vs vector as default Seq implementation
* add healing period for "invalid" (?) solutions
  * default value is none/identity
  * demonstrate with healing salesman (chromosome is sequence with duplicates, heals to unique sequence)
    * determinisitically with canonical sequence (slower?)
    * or recklessly with canonical set (faster?)
* describe base hierarchy
* describe combinatorics hierarchy
* doc primary methods and overrides by traits
* consider external operators so that value classes need not extend a trait
  * gut chromosome methods
* explore spontaneous generation and how it links to fixed/variable length homogenous chromosomes
* need drosophilia/helloworld
  * sodoku??
* support arbitrary types?
* support arbitary fitness?
* fitness min/maxer (implies ordered?)
* sample generator
* mutation/combination operators (provided as list?)
  * implemented as seq yields seq?
* selection operators
  * proportional to fitness?
  * select random parents?
  * elitism?
* supported chromosome types
  * fixed length homogenous (Seq[T])
    * cross over, spot mutation (requires () => T, or Chromosome => T)
  * variable length homogenous (Stack[T])
* termination conditions
  * time elapsed
  * generations elapsed
  * state fitness improvmeent
  * target fitness reached
  * and/or

## Redesign

population evolver. does not specify mutation or crossover. input Seq[A] output Seq[A]. if A itself is also a Seq, can support by default mutation and popular crossover operations

population manager? used to control islands?

population evolver itself has termination conditions

better, earlier support for Array[Int/Double] as chromosomes

framework for working with Int over discrete collections/as chromosomes
