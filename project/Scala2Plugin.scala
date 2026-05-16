import sbt.Keys.*
import sbt.*

/**
  * Automatically enriches projects with the following settings (despite the word "override").
  */
object Scala2Plugin extends AutoPlugin {

  /**
    * Thus plug-in will automatically be enabled; it has no requirements.
    */
  override def trigger: PluginTrigger = AllRequirements

  override val buildSettings: Seq[Setting[?]] = Seq(
    scalaVersion := "2.13.18"
  )

  // putting into project settings helps with late binding for properly detecting scala3 cross build
  override val projectSettings: Seq[Setting[?]] = Seq(
    scalacOptions ++= scala3Syntax(scalaVersion.value)
  )

  private def scala3Syntax(s: String) =
    CrossVersion.partialVersion(s) match {
      case Some((2, _)) =>
        Seq("-Xsource:3")

      case _ =>
        Nil
    }
}
