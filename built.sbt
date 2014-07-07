name := "spawning-pool"

organization := "com.htmlism"

version := "0.0.1-SNAPSHOT"

autoAPIMappings := true

initialCommands in console := "import com.htmlism.spawningpool_"

libraryDependencies += "org.specs2" %% "specs2" % "2.3.12" % "test"
