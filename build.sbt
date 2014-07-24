lazy val solver = project

lazy val `hello-world` = project
  .dependsOn(solver)
