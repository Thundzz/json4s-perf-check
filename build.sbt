import Dependencies._

ThisBuild / scalaVersion     := "2.13.3"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "org.scala"
ThisBuild / organizationName := "thundzz"

lazy val root = (project in file("."))
  .settings(
    name := "json4s-perf-check",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.6.10"
  )
