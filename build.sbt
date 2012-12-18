name := "machines"

version := "0.0.1-atlassian-M1"

resolvers += "Scala Tools Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0-M6"
, "org.scalaz" %% "scalaz-effect" % "7.0.0-M6"
, "org.scalacheck" %% "scalacheck" % "1.9" % "test"
)

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-Ydependent-method-types", "-unchecked")
