name := "spawning-pool"

organization := "com.htmlism"

version := "0.0.1-SNAPSHOT"

autoAPIMappings := true

libraryDependencies += "org.specs2" %% "specs2" % "2.4.6" % "test"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

initialCommands in console := "import com.htmlism.spawningpool._"
