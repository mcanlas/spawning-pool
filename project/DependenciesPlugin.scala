import sbt.Keys.*
import sbt.*

object DependenciesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    implicit class DependencyOps(p: Project) {
      val circeYamlVersion =
        "0.16.1"

      def withCats: Project =
        p
          .settings(libraryDependencies += "org.typelevel" %% "cats-core" % "2.13.0")

      def withEffectMonad: Project =
        p.settings(libraryDependencies += "org.typelevel" %% "cats-effect" % "3.7.0")

      def withTesting: Project = {
        val weaverVersion =
          "0.10.1"

        p.settings(
          libraryDependencies ++= Seq(
            "org.typelevel" %% "weaver-cats"       % weaverVersion % Test,
            "org.typelevel" %% "weaver-scalacheck" % weaverVersion % Test
          )
        )
      }

      def withYaml: Project =
        p.settings(
          libraryDependencies ++= Seq(
            "io.circe" %% "circe-yaml" % circeYamlVersion
          )
        )
    }
  }
}
