name := "spawning-pool"

organization := "com.htmlism"

autoAPIMappings := true

libraryDependencies += "org.specs2" %% "specs2" % "2.4.6" % "test"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases" // for specs2

initialCommands in console := "import com.htmlism.spawningpool._"
