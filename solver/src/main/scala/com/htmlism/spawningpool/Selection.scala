package com.htmlism.spawningpool

/**
  * A trait that represents a strategy for reducing a population to a smaller set of chromosomes. These chromosomes would
  * be the parents for a crossover operation.
  *
  * Since genetic crossover typically involves two parents, this operation will usually return a collection of two
  * chromosomes.
  *
  * @tparam A The type of the chromosomes
  */

trait Selection[A] {
  /**
    * Returns a collection of chromosomes for purposes of crossover.
    *
    * @param xs A collection of chromosomes
    * @return A collection of chromosomes
    */

  def select(xs: TraversableOnce[A]): TraversableOnce[A]
}

class TournamentSelection[A, B](fitness: A => B, sampler: Sampling, size: Int)(implicit ordering: Ordering[B]) extends Selection[A] {
  def select(xs: TraversableOnce[A]): TraversableOnce[A] = {
    import TournamentSelection._

    val seq = xs.toSeq

    Iterator.fill(2)(selectOne(seq, fitness, sampler, size))
  }
}

object TournamentSelection {
  def selectOne[A, B](xs: TraversableOnce[A], fitness: A => B, sampler: Sampling, size: Int)(implicit ordering: Ordering[B]): A = {
    val entrants = Iterator.fill(size)(sampler.sample(xs))

    entrants.reduce((a, b) => maxByFitness(fitness, a, b))
  }

  def maxByFitness[A, B](fitness: A => B, a: A, b: A)(implicit ordering: Ordering[B]): A = {
    val af = fitness(a)
    val bf = fitness(b)

    if (ordering.gteq(af, bf))
      a
    else
      b
  }
}
