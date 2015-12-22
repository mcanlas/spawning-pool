import sbtrelease.ReleaseStateTransformations._

scalaVersion := "2.11.7"

lazy val solver = project

lazy val benchmark = project dependsOn solver

crossScalaVersions := Seq("2.10.6", "2.11.7")

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
