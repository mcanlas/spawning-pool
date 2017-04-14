import sbtrelease.ReleaseStateTransformations._

val commonSettings = Seq(
  scalaVersion := "2.12.1",
  crossScalaVersions := Seq("2.10.6", "2.11.10", "2.12.1"))

lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(commonSettings: _*)

lazy val benchmark = project
  .settings(commonSettings: _*)
  .dependsOn(core)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(core, benchmark)

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
