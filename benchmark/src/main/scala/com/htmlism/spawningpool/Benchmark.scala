package com.htmlism.spawningpool

object Benchmark {
  def apply(f: () => Unit, times: Int): Unit = {
    val durations = for (n <- 1 to times) yield {
      println(s"Running $n...")

      val start = compat.Platform.currentTime

      f()

      val duration = compat.Platform.currentTime - start
      val duratinInSeconds = duration / 1000

      println(s"Duration was $duratinInSeconds seconds")
      println()

      duration
    }

    val averageDurationInSeconds = durations.sum / times / 1000

    println(s"Average duration was $averageDurationInSeconds seconds")
  }
}
