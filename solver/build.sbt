name := "spawning-pool"

organization := "com.htmlism"

autoAPIMappings := true

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

libraryDependencies += "org.specs2" %% "specs2" % "2.4.17" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.4" % "test"

initialCommands in console := "import com.htmlism.spawningpool._"
