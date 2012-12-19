name := "machines"

organization := "com.clarifi"

version := "0.0.1-atlassian-M1"

licenses := Seq("BSD-style" -> url("https://github.com/runarorama/scala-machines/blob/master/LICENSE"))

homepage := Some(url("https://github.com/runarorama/scala-machines"))

pomExtra := (
    <scm>
        <url>git@github.com:atlassian/scala-machines.git</url>
        <connection>scm:git:git@github.com:atlassian/scala-machines.git</connection>
        <developerConnection>scm:git:git@github.com:atlassian/scala-machines.git</developerConnection>
    </scm>
    <distributionManagement>
        <repository>
            <id>atlassian-3rdparty</id>
            <url>https://maven.atlassian.com/3rdparty</url>
        </repository>
        <snapshotRepository>
            <id>atlassian-3rdparty-snapshot</id>
            <url>https://maven.atlassian.com/3rdparty-snapshot</url>
        </snapshotRepository>
    </distributionManagement>
)

resolvers += "Scala Tools Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0-M6"
, "org.scalaz" %% "scalaz-effect" % "7.0.0-M6"
, "org.scalacheck" %% "scalacheck" % "1.9" % "test"
)

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-deprecation", "-Ydependent-method-types", "-unchecked")

mappings in (Compile, packageBin) ++= Seq(
    file("LICENSE") -> "META-INF/LICENSE"
)
