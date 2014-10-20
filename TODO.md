* http://people.sc.fsu.edu/~jburkardt/datasets/tsp/tsp.html
* one discrete set should be able to yield a tuple of (evolver, generator)
* consider external operators so that value classes need not extend a trait
  * gut chromosome methods
* explore spontaneous generation and how it links to fixed/variable length homogenous chromosomes
* need drosophilia/helloworld
  * sodoku??
* document type parameters
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
* mutation
  * T => T
* supported chromosome types
  * fixed length homogenous (Seq[T])
    * cross over, spot mutation (requires () => T, or Chromosome => T)
  * variable length homogenous (Stack[T])
* do termination conditions need operators? 'and' and 'or'
* should the chromosome /value class/ and its constructors/factories be seperate?
