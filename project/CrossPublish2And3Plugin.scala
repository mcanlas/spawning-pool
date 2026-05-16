import sbt.Keys.*
import sbt.*

/**
  * Automatically enriches projects with the following settings (despite the word "override").
  */
object CrossPublish2And3Plugin extends AutoPlugin {

  /**
    * Thus plug-in will automatically be enabled; it has no requirements.
    */
  override def trigger: PluginTrigger = AllRequirements

  override val buildSettings: Seq[Setting[?]] = Seq(
    crossScalaVersions := Seq("2.13.18")
  )
}
