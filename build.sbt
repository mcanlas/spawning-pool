import sbtrelease.ReleaseStateTransformations._

val commonSettings = Seq(
  scalaVersion := "2.12.2",
  crossScalaVersions := Seq("2.10.6", "2.11.11", "2.12.2"))

lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(commonSettings: _*)

lazy val scalaz = Project("spawning-pool-scalaz", file("spawning-pool-scalaz"))
  .settings(commonSettings: _*)
  .dependsOn(core)

lazy val benchmark = project
  .settings(commonSettings: _*)
  .dependsOn(core)

lazy val root = Project("spawning-pool", file("."))
  .settings(commonSettings: _*)
  .aggregate(core, scalaz, benchmark)

releaseSettings

ReleaseKeys.releaseProcess := Seq(
  checkSnapshotDependencies,
  inquireVersions,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges)

publishArtifact := false
