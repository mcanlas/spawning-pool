import sbtrelease.ReleaseStateTransformations._

val commonSettings = Seq(
  organization := "com.htmlism",
  scalaVersion := "2.12.2",
  crossScalaVersions := Seq("2.10.6", "2.11.11", "2.12.2"))

lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(commonSettings: _*)
  .settings(specs2: _*)
  .settings(betterConsole)

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

lazy val specs2 = Seq(
  resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases", // for specs2
  libraryDependencies += "org.specs2" %% "specs2-core" % "3.9.4" % "test",
  libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.5" % "test")

lazy val betterConsole = initialCommands in console := "import com.htmlism.spawningpool._"
