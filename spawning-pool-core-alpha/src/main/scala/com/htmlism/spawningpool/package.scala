package com.htmlism

package object spawningpool {
  type Generation[A] = generation.Generation[A]
  type Evolution[A]  = evolution.Evolution[A]
  type Fitness[A]    = fitness.Fitness[A]
}
