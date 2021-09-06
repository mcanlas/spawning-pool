package com.htmlism.spawningpool

object Benchmark {
  private def toDurations(times: Int)(f: () => Unit): Seq[Long] =
    for (n <- 1 to times) yield {
      println()
      println(s"Running $n...")

      val start = compat.Platform.currentTime

      f()

      val duration = compat.Platform.currentTime - start
      val duratinInSeconds = duration / 1000

      duratinInSeconds
    }

  def apply[A](fs: Map[A, () => Unit], times: Int): Unit = {
    val durations = fs
      .mapValues(toDurations(times))
      .map(identity)

    println("Durations:")
    durations.foreach(println)

    val averages = durations
      .mapValues(_.sum / times)

    println("Average duration:")
    averages.foreach(println)
  }
}
