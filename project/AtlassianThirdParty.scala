import sbt._
import Keys._

object AtlassianThirdParty extends Plugin {
    override def settings = Seq(
        publishTo <<= version { (v: String) =>
            val nexus = "https://maven.atlassian.com/3rdparty/"

            if (v.trim.endsWith("SNAPSHOT"))
                Some("snapshots" at nexus + "content/repositories/snapshots")
            else
                Some("releases"  at nexus + "service/local/staging/deploy/maven2")
        }
    )
}
