import sbtrelease.ReleaseStateTransformations._

val commonSettings = Seq(
  scalaVersion := "2.12.1",
  crossScalaVersions := Seq("2.10.6", "2.11.9", "2.12.1"))

lazy val solver = project
  .settings(commonSettings: _*)

lazy val benchmark = project
  .settings(commonSettings: _*)
  .dependsOn(solver)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .aggregate(solver, benchmark)

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
