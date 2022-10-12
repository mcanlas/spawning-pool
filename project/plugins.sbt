addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"       % "0.4.1")
addSbtPlugin("com.github.gseitz"         % "sbt-release"        % "1.0.6")
addSbtPlugin("org.wartremover"           % "sbt-wartremover"    % "3.0.6")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"      % "2.0.1")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix"       % "0.10.4")
addSbtPlugin("com.codecommit"            % "sbt-github-actions" % "0.14.2")
