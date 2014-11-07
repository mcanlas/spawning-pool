package com.htmlism.spawningpool

/**
 * A base trait for sources that can generate chromosomes
 *
 * @tparam A The type of the chromosome
 */

trait ChromosomeGenerator[A] {
  def generateChromosome: A
}
