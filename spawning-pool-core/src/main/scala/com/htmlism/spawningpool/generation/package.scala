package com.htmlism.spawningpool

import scala.util.Random

package object generation {
  private[generation] val DEFAULT_ARRAY_LENGTH = 100

  private[generation] val rngInt = () => Random.nextInt
  private[generation] val rngDouble = () => Random.nextDouble

  private[generation] val rngLength = (max: Int) => Random.nextInt(max)
}
