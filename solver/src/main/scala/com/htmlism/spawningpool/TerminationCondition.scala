package com.htmlism.spawningpool

trait TerminationCondition {
  def shouldTerminate: Boolean

  def and(otherCondition: TerminationCondition): TerminationCondition = JointCondition(this, otherCondition)

  def or(otherCondition: TerminationCondition): TerminationCondition = DisjointCondition(this, otherCondition)
}

final case class JointCondition(left: TerminationCondition, right: TerminationCondition) extends TerminationCondition {
  def shouldTerminate: Boolean = left.shouldTerminate && right.shouldTerminate
}

final case class DisjointCondition(left: TerminationCondition, right: TerminationCondition) extends TerminationCondition {
  def shouldTerminate: Boolean = left.shouldTerminate || right.shouldTerminate
}
