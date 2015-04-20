import sbtrelease.ReleaseStateTransformations._

lazy val solver = project

crossScalaVersions := Seq("2.10.5", "2.11.6")

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
