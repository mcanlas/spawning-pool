import sbt.Keys.*
import sbt.*
import scalafix.sbt.ScalafixPlugin.autoImport.*
import wartremover.Wart
import wartremover.WartRemover.autoImport.*

object LintingPlugin extends AutoPlugin {
  override def trigger =
    allRequirements

  override val globalSettings =
    addCommandAlias("fmt", "; scalafmtSbt; scalafmtAll") ++
      addCommandAlias("fix", "scalafixAll")

  override val buildSettings =
    Seq(
      wartremoverWarnings ++= Warts.unsafe diff List(Wart.Any),
      semanticdbEnabled := true,
      semanticdbVersion := scalafixSemanticdb.revision
    )
}
