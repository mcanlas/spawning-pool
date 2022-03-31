addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"    % "0.1.20")
addSbtPlugin("com.github.gseitz"         % "sbt-release"     % "1.0.6")
addSbtPlugin("org.wartremover"           % "sbt-wartremover" % "2.4.18")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"   % "1.9.3")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix"    % "0.9.34")
