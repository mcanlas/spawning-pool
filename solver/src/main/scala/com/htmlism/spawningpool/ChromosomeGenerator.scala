package com.htmlism.spawningpool

trait ChromosomeGenerator[A] {
  def generateChromosome: A
}
