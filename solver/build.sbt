name := "spawning-pool"

organization := "com.htmlism"

autoAPIMappings := true

libraryDependencies += "org.specs2" %% "specs2" % "2.4.11" % "test"

initialCommands in console := "import com.htmlism.spawningpool._"
