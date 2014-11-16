import sbtrelease.ReleaseStateTransformations._

lazy val solver = project

crossScalaVersions := Seq("2.10.4", "2.11.4")

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
