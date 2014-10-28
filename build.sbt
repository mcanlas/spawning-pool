lazy val solver = project

lazy val `example-hello-world` = project
  .dependsOn(solver)

lazy val `example-traveling-salesman` = project
  .dependsOn(solver)
