package com.htmlism.spawningpool

import scala.concurrent.ExecutionContext.Implicits.global

import com.htmlism.spawningpool.combinatorics._

object VectorVsArray extends App {
  Benchmark(Map("vector of ref" -> withVector _,
                "vector of int" -> withVectorInt _,
                "array of ref"  -> withArray _,
                "array of int"  -> withArrayInt _),
            10)

  def withVectorInt(): Unit = {
    implicit val combinator = new DiscreteFixedLengthCombinator(1 to 100, 100)

    val solver = new Solver[Seq[Int], Int]({ _ =>
      util.Random.nextInt()
    }, islandCount = PositiveCount(15), populationSize = PositiveCount(1000), generations = PositiveCount(40))

    val _ = solver.solveNow
  }

  def withArrayInt(): Unit = {
    implicit val combinator =
      new specialized.DiscreteFixedLengthCombinator(1 to 100, 100)

    val solver = new Solver[Seq[Int], Int]({ _ =>
      util.Random.nextInt()
    }, islandCount = PositiveCount(15), populationSize = PositiveCount(1000), generations = PositiveCount(40))

    val _ = solver.solveNow
  }

  def withVector(): Unit = {
    implicit val combinator =
      new DiscreteFixedLengthCombinator((1 to 100).map(WrappedInt), 100)

    val solver = new Solver[Seq[WrappedInt], Int]({ _ =>
      util.Random.nextInt()
    }, islandCount = PositiveCount(15), populationSize = PositiveCount(1000), generations = PositiveCount(40))

    val _ = solver.solveNow
  }

  def withArray(): Unit = {
    implicit val combinator = new specialized.DiscreteFixedLengthCombinator((1 to 100).map(WrappedInt), 100)

    val solver = new Solver[Seq[WrappedInt], Int]({ _ =>
      util.Random.nextInt()
    }, islandCount = PositiveCount(15), populationSize = PositiveCount(1000), generations = PositiveCount(40))

    val _ = solver.solveNow
  }
}

case class WrappedInt(a: Int)
