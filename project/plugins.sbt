addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.2.3")
addSbtPlugin("com.github.gseitz"         % "sbt-release"     % "1.0.6")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "3.0.0")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"   % "1.9.3")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix"    % "0.10.0")
