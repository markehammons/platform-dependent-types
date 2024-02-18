lazy val scalaV = "3.3.1"
lazy val munitV = "1.0.0-M11"
lazy val munit =
  "org.scalameta" %% "munit" % "1.0.0-M11" % Test

lazy val root = project
  .in(file("."))
  .aggregate(
    naive,
    `path-dependent-types`,
    `opaque-types-1`
  )

lazy val naive =
  project.settings(
    scalaVersion := scalaV,
    libraryDependencies += munit
  )

lazy val `path-dependent-types` =
  project.settings(
    scalaVersion := scalaV,
    libraryDependencies += munit
  )

lazy val `opaque-types-1` =
  project.settings(
    scalaVersion := scalaV,
    libraryDependencies += munit
  )
