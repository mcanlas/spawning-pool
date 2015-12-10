scalaVersion := "2.11.7"

name := "spawning-pool"

organization := "com.htmlism"

autoAPIMappings := true

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.6" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.5" % "test"

initialCommands in console := "import com.htmlism.spawningpool._"
