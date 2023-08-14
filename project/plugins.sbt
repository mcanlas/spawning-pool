addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.0")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("org.typelevel"     % "sbt-tpolecat"    % "0.5.0")
addSbtPlugin("com.github.gseitz" % "sbt-release"     % "1.0.6")
addSbtPlugin("org.wartremover"   % "sbt-wartremover" % "3.1.3")
addSbtPlugin("org.scoverage"     % "sbt-scoverage"   % "2.0.6")
addSbtPlugin("ch.epfl.scala"     % "sbt-scalafix"    % "0.11.0")
