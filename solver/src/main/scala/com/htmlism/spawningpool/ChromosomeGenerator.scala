package com.htmlism.spawningpool

trait ChromosomeGenerator[A] {
  def generate: A
}