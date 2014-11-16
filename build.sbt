lazy val solver = project

lazy val `example-traveling-salesman` = project
  .dependsOn(solver)
