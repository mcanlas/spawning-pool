import sbt.Keys._
import sbt._
import scalafix.sbt.ScalafixPlugin.autoImport._

object LintingPlugin extends AutoPlugin {
  override def trigger = allRequirements

  override val globalSettings =
    addCommandAlias("fmt", "scalafmtAll") ++
      addCommandAlias("fix", "scalafixAll")

  override val projectSettings =
    inThisBuild(
      Seq(
        scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.4.4",
        semanticdbEnabled := true,
        semanticdbVersion := scalafixSemanticdb.revision
      )
    )
}
