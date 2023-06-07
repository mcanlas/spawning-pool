import sbt.Keys._
import sbt._
import scalafix.sbt.ScalafixPlugin.autoImport._

object LintingPlugin extends AutoPlugin {
  override def trigger =
    allRequirements

  override val globalSettings =
    addCommandAlias("fmt", "; scalafmtSbt; scalafmtAll") ++
      addCommandAlias("fix", "scalafixAll")

  override val buildSettings =
    Seq(
      semanticdbEnabled := true,
      semanticdbVersion := scalafixSemanticdb.revision
    )
}
