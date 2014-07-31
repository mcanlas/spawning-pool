* maybe keep everything in a solver class to unify the type, but then implement it using testable object methods
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
