addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.1.16")
addSbtPlugin("com.github.gseitz"         % "sbt-release"     % "1.0.6")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "2.4.13")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"   % "1.5.1")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix"    % "0.9.24")
