package com.htmlism.spawningpool.combinatorics

trait ChromosomeGenerator[A] {
  def generateChromosome: A
}
