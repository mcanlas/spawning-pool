lazy val core = Project("spawning-pool-core", file("spawning-pool-core"))
  .settings(specs2*)
  .settings(betterConsole)

lazy val coreAlpha =
  Project("spawning-pool-core-alpha", file("spawning-pool-core-alpha"))
    .settings(fs2*)
    .settings(specs2*)
    .settings(betterConsole)

lazy val coreCats =
  Project("spawning-pool-scalaz", file("spawning-pool-scalaz"))
    .dependsOn(coreAlpha)

lazy val benchmark = project
  .dependsOn(core)

lazy val storage =
  module("storage")
    .settings(description := "Support for persisting populations")
    .withEffectMonad
    .withYaml

lazy val root = Project("spawning-pool", file("."))
  .aggregate(core, benchmark, coreAlpha, storage)

publishArtifact := false

lazy val fs2 = Seq(libraryDependencies += "co.fs2" %% "fs2-core" % "2.0.0")

lazy val specs2 = Seq(
  libraryDependencies += "org.specs2"     %% "specs2-core" % "4.10.6" % "test",
  libraryDependencies += "org.scalacheck" %% "scalacheck"  % "1.17.0" % "test"
)

lazy val betterConsole = console / initialCommands := "import com.htmlism.spawningpool._"
