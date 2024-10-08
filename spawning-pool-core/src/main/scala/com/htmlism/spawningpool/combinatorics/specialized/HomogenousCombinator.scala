package com.htmlism.spawningpool.combinatorics.specialized

import scala.collection.immutable.ArraySeq
import scala.reflect.ClassTag

import com.htmlism.spawningpool.combinatorics

trait HomogenousCombinator[A] extends combinatorics.HomogenousCombinator[A] {
  implicit def classTag: ClassTag[A]

  override def fill(size: Int): (=> A) => Seq[A] = { fill =>
    ArraySeq.unsafeWrapArray(Array.fill[A](size)(fill))
  }
}
