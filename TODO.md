* need variable length provider
* because tsp may have high local sensitivity, consider "twist" (pivot parents around one index) operator. also does not suffer from boundary bias because the solutions are a cycle (i.e. one cycle can be encoded many times ABC BCA CAB all cyclically equal)
* maybe tsp can be rethought as a list of edges, and fitness is sorted by the longest unbreaking tour (the "power" of the tour)
* for tsp, free combinatorial spot mutate probably performs very differently than the swap mutator; test both
* push all random activities into traits, and then have the default random provider extend all of them
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

## Next major release

* expose generations count
