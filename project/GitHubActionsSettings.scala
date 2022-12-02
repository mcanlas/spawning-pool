import sbt._
import sbtghactions._
import sbtghactions.GenerativeKeys._

/**
  * Automatically enriches projects with the following settings (despite the word "override").
  */
object GitHubActionsSettings extends AutoPlugin {

  /**
    * Thus plug-in will automatically be enabled; it has no requirements.
    */
  override def trigger: PluginTrigger = AllRequirements

  override def requires: Plugins =
    GitHubActionsPlugin

  override val buildSettings: Seq[Setting[_]] = Seq(
    githubWorkflowBuild                 := Seq(WorkflowStep.Sbt(List("scalafixAll --check", "scalafmtCheck", "test"))),
    githubWorkflowEnv                   := Map.empty,
    githubWorkflowPublishTargetBranches := Nil,
    githubWorkflowIncludeClean          := false
  )
}
