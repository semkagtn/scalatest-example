name := "scalatest-example"

organization := "com.semkagtn"

version := "0.1"

scalaVersion := "2.13.1"

scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-explaintypes",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xfatal-warnings", // important
  "-language:implicitConversions"
)

libraryDependencies ++= Seq(
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.1",
  "org.scalacheck" %% "scalacheck" % "1.14.3",
  "org.scalatestplus" %% "scalacheck-1-14" % "3.1.1.1"
).map(_ % Test)
