name := "machines"

version := "0.0.1-atlassian-M1"

licenses := Seq("BSD-style" -> url("https://github.com/runarorama/scala-machines/blob/master/LICENSE"))

homepage := Some(url("https://github.com/runarorama/scala-machines"))

pomExtra := (
    <scm>
        <url>git@github.com:runarorama/scala-machines.git</url>
        <connection>scm:git:git@github.com:runarorama/scala-machines.git</connection>
    </scm>
)

resolvers += "Scala Tools Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0-M6"
, "org.scalaz" %% "scalaz-effect" % "7.0.0-M6"
, "org.scalacheck" %% "scalacheck" % "1.9" % "test"
)

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-Ydependent-method-types", "-unchecked")
