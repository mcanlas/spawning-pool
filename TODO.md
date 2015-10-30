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
* do termination conditions need operators? 'and' and 'or'
