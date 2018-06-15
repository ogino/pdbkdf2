import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "jp.jofi",
      scalaVersion := "2.12.5",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "encrypt",
    libraryDependencies ++= Seq(
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      "io.github.nremond" %% "pbkdf2-scala" % "0.6.3",
      "org.specs2" %% "specs2-core" % "4.2.0" % Test
    ),
    scalacOptions in Test ++= Seq("-Yrangepos"),
    parallelExecution in Test := false
  )

