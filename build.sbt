lazy val munit =
  "org.scalameta" %% "munit" % "1.0.0-M11" % "test"

lazy val cats =
  "org.typelevel" %% "cats-core" % "2.10.0"

inThisBuild(
  Seq(
    scalaVersion := "3.3.2",
    libraryDependencies += munit,
    libraryDependencies += cats
  )
)
lazy val root = project
  .in(file("."))
  .aggregate(
    naive,
    `path-dependent-types`,
    `opaque-types-1`,
    `opaque-types-2`
  )

lazy val naive =
  project

lazy val `path-dependent-types` =
  project

lazy val `opaque-types-1` =
  project

lazy val `opaque-types-2` =
  project
