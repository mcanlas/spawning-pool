import sbt.*
import sbt.Keys.*

/**
  * Automatically enriches projects with the following settings (despite the word "override").
  */
object CatsEffectForkPlugin extends AutoPlugin {

  /**
    * Thus plug-in will automatically be enabled; it has no requirements.
    */
  override def trigger: PluginTrigger =
    AllRequirements

  // cats-effect prefers to run in its own main thread
  // https://github.com/typelevel/cats-effect/pull/3774
  override val buildSettings: Seq[Setting[?]] = Seq(
    fork := true
  )
}
