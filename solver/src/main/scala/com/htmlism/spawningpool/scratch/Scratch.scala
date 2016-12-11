package com.htmlism.spawningpool.scratch

import scala.concurrent.{ExecutionContext, Future}

import com.htmlism.spawningpool._

class Scratch {
}

// evolution engine = population manager + generator

// fitness function + generator + population manager
//
// population manager = ecosystem(islands) + termination condition
// Trav[Sol] => Trav[Sol]
//
// islands[Sol] => islands[Sol]
// genetic solver = mutation method + crossover method
// crossover Seq[A] => A

trait EvolutionEngine[A] {
  def generator: Generator[A]

  def evolve(implicit ec: ExecutionContext): Future[TraversableOnce[A]]
}

trait IslandEvolutionEngine[A] extends EvolutionEngine[A] {
  def numberOfIslands: Int
}

object GeneticEvolutionEngine {
  def apply[A, B](
    fitnessFunction: A => B,
    numberOfIslands: Int = 1)
    (implicit generator: Generator[A],
      mutation: Mutation[A],
      crossover: Crossover[A]): GeneticEvolutionEngine[A, B] = new ImmutableEngine[A, B](???, ???, ???, ???, ???)

  class ImmutableEngine[A, B](
                               val fitnessFunction: A => B,
                               val numberOfIslands: Int,
                               val generator: Generator[A],
                               mutation: Mutation[A],
                               crossover: Crossover[A]
                             ) extends GeneticEvolutionEngine[A, B] {
    private val evolver = {
      fitnessFunction
      mutation
      crossover

      ??? : GeneticEvolver[A, B]
    }

    def evolve(implicit ec: ExecutionContext): Future[TraversableOnce[A]] = {
      val islands = scala.collection.mutable.Seq.fill(numberOfIslands)(generationFuturePopulation)

      var generations = 0

      def currentContext: EvolutionaryContext[B] = ???

      while (generations < 10) {
        for (i <- islands.indices) {
          islands(i) = islands(i).map(evolver.evolve)
        }

        generations += 1
      }

      Future
        .sequence(islands.toIterator)
        .map(_.flatten)
    }

    private def generationFuturePopulation(implicit ec: ExecutionContext) = Future {
      Seq.fill(50)(generator.generate): TraversableOnce[A]
    }
  }
}

trait GeneticEvolutionEngine[A, B] extends IslandEvolutionEngine[A]

trait FitnessFunction[A, B] extends (A => B)

trait Population[A] {
  def solutions: TraversableOnce[A]
}

trait Ecosystem[A, B] {
  def islands = ??? // each has Seq[Population]
}

trait EvolutionaryContext[A] {
  def generationNumber: Int

  def timeElapsed: Long

  def population: TraversableOnce[A]
}

trait PopulationEvolver[A] {
  def evolve(xs: TraversableOnce[A]): TraversableOnce[A]
}

trait GeneticEvolver[A, B] extends PopulationEvolver[A] {
  def fitness: A => B

  def mutation: Mutation[A]

  def crossover: Crossover[A]

  def selection: Selection[A]

  def evolve(xs: TraversableOnce[A]): TraversableOnce[A] = ???
}

object GeneticEvolver {
  def apply[A, B](fitness: A => B)
    (implicit mutation: Mutation[A],
      crossover: Crossover[A],
      ordering: Ordering[B]): GeneticEvolver[A, B] = {
    val selection = new TournamentSelection(fitness, RandomSampler, 2)

    new ImmutableGeneticEvolver(fitness, mutation, crossover, selection)
  }

  class ImmutableGeneticEvolver[A, B](
    val fitness: A => B,
    val mutation: Mutation[A],
    val crossover: Crossover[A],
    val selection: Selection[A]) extends GeneticEvolver[A, B]
}
