addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(
  Resolver.ivyStylePatterns
)
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.1.13")
addSbtPlugin("com.github.gseitz"         % "sbt-release"  % "1.0.6")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
