package com.htmlism.spawningpool

import scala.annotation.tailrec
import scala.concurrent._
import scala.concurrent.duration._

object Solver {
  val DEFAULT_POPULATION_SIZE  = PositiveCount(50)
  val DEFAULT_ISLAND_COUNT     = PositiveCount(4)
  val DEFAULT_GENERATION_COUNT = PositiveCount(20)
  val DEFAULT_MUTATION_RATE    = .01

  def randomIndividual[A](population: Seq[A])(implicit rig: RandomIndexProvider): A =
    population(rig.randomIndex(population.size))

  def evolvePopulation[A, B](implicit ctx: SolutionContext[A, B]): SolutionContext[A, B] = {
    println(s"island ${ctx.islandId} generating children for generation ${ctx.generations}")

    val newPopulation = Vector.fill(ctx.population.size)(bearChild)

    ctx.increment(newPopulation)
  }

  def tournamentSelect[A, B](size: PositiveCount)(implicit ctx: SolutionContext[A, B]): A =
    tournamentSelect(size, randomIndividual(ctx.population))

  @tailrec
  private def tournamentSelect[A, B](size: PositiveCount, champion: A)(implicit ctx: SolutionContext[A, B]): A =
    if (size == PositiveCount(1))
      champion
    else {
      val challenger = randomIndividual(ctx.population)
      val compare =
        ctx.ordering.compare(ctx.fitness(champion), ctx.fitness(challenger))

      val nextChampion = if (compare < 0) challenger else champion

      tournamentSelect(size.minusOne, nextChampion)
    }

  def bearChild[A, B](implicit ctx: SolutionContext[A, B]): A = {
    val child = ctx.evolver.crossover(tournamentSelect(PositiveCount(2)), tournamentSelect(PositiveCount(2)))

    if ((new scala.util.Random).nextDouble < ctx.mutationRate)
      ctx.evolver.mutate(child)
    else
      child
  }

  def awaitResult[A](future: Future[A]): A = Await.result(future, Duration.Inf)
}

/**
  * A generator of solutions configured with tuning parameters.
  *
  * @param fitness A function for determining the fitness score B of candidate solutions A
  * @param populationSize The number of solutions in each population
  * @param islandCount The number of islands in each
  * @param mutationRate The rate of mutation from 0 to 1
  * @param generations The number of generations to evolve
  * @param evolver The mechanism responsible for evolving candidate solutions
  * @param ordering An ordering for values of B
  * @param rig The source of randomness
  *
  * @tparam A The type of the candidate solutions
  * @tparam B The type of the fitness score
  */
class Solver[A, B](
    fitness: A => B,
    populationSize: PositiveCount = Solver.DEFAULT_POPULATION_SIZE,
    islandCount: PositiveCount = Solver.DEFAULT_ISLAND_COUNT,
    mutationRate: Double = Solver.DEFAULT_MUTATION_RATE,
    generations: PositiveCount = Solver.DEFAULT_GENERATION_COUNT
)(implicit evolver: Evolver[A], ordering: Ordering[B]) {
  import com.htmlism.spawningpool.Solver._

  type Population = Vector[A]
  type Solutions  = Set[A]

  def solve(implicit src: ChromosomeGenerator[A], ec: ExecutionContext): Future[Solutions] = Future {
    evolveFrom { Vector.fill(populationSize)(src.generateChromosome) }
  }

  def solve(seed: Traversable[A])(implicit ec: ExecutionContext): Future[Solutions] = Future {
    if (seed.isEmpty)
      throw new IllegalArgumentException("must provide a non-empty collection as a seed")
    else
      evolveFrom {
        seed.toVector
      }
  }

  def solveNow(implicit src: ChromosomeGenerator[A], ec: ExecutionContext): Solutions = awaitResult(solve)

  def solveNow(seed: Traversable[A])(implicit ec: ExecutionContext): Solutions =
    awaitResult(solve(seed))

  private def evolveFrom(seeding: => Population)(implicit ec: ExecutionContext) = {
    val islands = generateIslands(seeding)

    val baseFutures = islands.zipWithIndex.map {
      case (p, i) =>
        Future {
          SolutionContext(i, fitness, evolver, mutationRate, p)
        }
    }

    val endFutures = evolveIslands(baseFutures, generations)

    val evolvedIslands = endFutures.map { f =>
      f.map { ctx =>
        val byFitness = ctx.population.groupBy(ctx.fitness)

        byFitness(byFitness.keys.max)
      }
    }

    evolvedIslands.foldLeft(Set.empty[A])((acc, sols) => acc ++ awaitResult(sols))
  }

  @tailrec
  private def evolveIslands(
      islands: Iterable[Future[SolutionContext[A, B]]],
      generations: Int
  )(implicit ec: ExecutionContext): Iterable[Future[SolutionContext[A, B]]] =
    generations match {
      case 0 => islands
      case _ =>
        val newIslands = islands.map { f =>
          f.map(evolvePopulation(_)) // type inference with implicits is hard
        }

        evolveIslands(newIslands, generations - 1)
    }

  private def generateIslands(f: => Population) = Iterable.fill(islandCount)(f)
}
