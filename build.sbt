lazy val solver = project

lazy val `hello-world` = project
  .dependsOn(solver)

lazy val `traveling-salesman` = project
  .dependsOn(solver)
