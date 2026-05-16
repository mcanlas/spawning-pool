package com.htmlism.spawningpool

object Benchmark {
  private def toDurations(times: Int)(f: () => Unit): Seq[Long] =
    for (n <- 1 to times) yield {
      println()
      println(s"Running $n...")

      val start = System.currentTimeMillis()

      f()

      val duration         = System.currentTimeMillis() - start
      val duratinInSeconds = duration / 1000

      duratinInSeconds
    }

  def apply[A](fs: Map[A, () => Unit], times: Int): Unit = {
    val durations = fs
      .map { case (k, v) => (k, toDurations(times)(v)) }

    println("Durations:")
    durations.foreach(println)

    val averages = durations
      .map { case (k, v) => (k, v.sum / times) }

    println("Average duration:")
    averages.foreach(println)
  }
}
