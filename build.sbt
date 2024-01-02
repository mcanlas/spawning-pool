import sbtrelease.ReleaseStateTransformations.*

val commonSettings = Seq(
  organization       := "com.htmlism",
  scalaVersion       := "2.13.12",
  crossScalaVersions := Seq("2.12.18", "2.13.12")
)

lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(commonSettings*)
  .settings(specs2*)
  .settings(betterConsole)

lazy val coreAlpha =
  Project("spawning-pool-core-alpha", file("spawning-pool-core-alpha"))
    .settings(commonSettings*)
    .settings(fs2*)
    .settings(specs2*)
    .settings(betterConsole)

lazy val coreCats =
  Project("spawning-pool-scalaz", file("spawning-pool-scalaz"))
    .settings(commonSettings*)
    .dependsOn(coreAlpha)

lazy val shapelessMutation = Project("spawning-pool-shapeless-mutation", file("spawning-pool-shapeless-mutation"))
  .settings(commonSettings*)
  .settings(shapeless)
  .dependsOn(coreAlpha)

lazy val benchmark = project
  .settings(commonSettings*)
  .dependsOn(core)

lazy val storage =
  module("storage")
    .settings(description := "Support for persisting populations")
    .withEffectMonad
    .withYaml

lazy val root = Project("spawning-pool", file("."))
  .settings(commonSettings*)
  .aggregate(core, benchmark, coreAlpha, storage)

releaseProcess := Seq(
  checkSnapshotDependencies,
  inquireVersions,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)

publishArtifact := false

lazy val fs2 = Seq(libraryDependencies += "co.fs2" %% "fs2-core" % "2.0.0")

lazy val shapeless = Seq(
  libraryDependencies ++= Seq("com.chuusai" %% "shapeless" % "2.3.3") ++
    (CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 10)) =>
        Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full))
      case _ => Nil
    })
)

lazy val specs2 = Seq(
  libraryDependencies += "org.specs2"     %% "specs2-core" % "4.10.6" % "test",
  libraryDependencies += "org.scalacheck" %% "scalacheck"  % "1.17.0" % "test"
)

lazy val betterConsole = console / initialCommands := "import com.htmlism.spawningpool._"
