scalaVersion := "2.11.8"

name := "spawning-pool"

organization := "com.htmlism"

autoAPIMappings := true

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

libraryDependencies += "org.specs2" %% "specs2-core" % "3.7.3" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.0" % "test"

initialCommands in console := "import com.htmlism.spawningpool._"
