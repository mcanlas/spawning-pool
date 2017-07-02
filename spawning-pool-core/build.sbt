organization := "com.htmlism"

autoAPIMappings := true

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

libraryDependencies += "org.specs2" %% "specs2-core" % "3.9.1" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.5" % "test"

initialCommands in console := "import com.htmlism.spawningpool._"
