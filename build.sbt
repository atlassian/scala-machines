name := "machines"

organization := "com.clarifi"

version := "0.0.1-atlassian-M2"

licenses := Seq("BSD-style" -> url("https://github.com/runarorama/scala-machines/blob/master/LICENSE"))

homepage := Some(url("https://github.com/runarorama/scala-machines"))

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.0-M8"

libraryDependencies += "org.scalaz" %% "scalaz-effect" % "7.0.0-M8"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.2", "2.10.0")

scalacOptions ++= Seq("-deprecation", "-unchecked")

scalacOptions <++= scalaVersion map {
  case sv if sv.contains("2.10") =>
    Seq("-feature", "-language:implicitConversions", "-language:higherKinds", "-language:existentials", "-language:postfixOps")
  case _ =>
    Seq("-Ydependent-method-types")
}

mappings in (Compile, packageBin) ++= Seq(
    file("LICENSE") -> "META-INF/LICENSE"
)

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
