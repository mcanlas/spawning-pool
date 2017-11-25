package com.htmlism

package object spawningpool {
  type Future[A] = scala.concurrent.Future[A]

  type Generation[A] = generation.Generation[A]
  type Evolution[A]  = evolution.Evolution[A]
  type Fitness[A]    = fitness.Fitness[A]
}
