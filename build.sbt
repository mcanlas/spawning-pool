import sbtrelease.ReleaseStateTransformations._

val commonSettings = Seq(
  organization := "com.htmlism",
  scalaVersion := "2.12.6",
  crossScalaVersions := Seq("2.10.7", "2.11.12", "2.12.6"))

lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(commonSettings: _*)
  .settings(specs2: _*)
  .settings(betterConsole)

lazy val coreAlpha = Project("spawning-pool-core-alpha", file("spawning-pool-core-alpha"))
  .settings(commonSettings: _*)
  .settings(specs2: _*)
  .settings(betterConsole)

lazy val scalaz = Project("spawning-pool-scalaz", file("spawning-pool-scalaz"))
  .settings(commonSettings: _*)
  .dependsOn(coreAlpha)

lazy val benchmark = project
  .settings(commonSettings: _*)
  .dependsOn(core)

lazy val root = Project("spawning-pool", file("."))
  .settings(commonSettings: _*)
  .aggregate(core, scalaz, benchmark, coreAlpha)

releaseProcess := Seq(
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
  libraryDependencies += "org.specs2" %% "specs2-core" % "3.9.5" % "test",
  libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % "test")

lazy val betterConsole = initialCommands in console := "import com.htmlism.spawningpool._"
