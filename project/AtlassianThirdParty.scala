import sbt._
import Keys._

object AtlassianThirdParty extends Plugin {
    override def settings = Seq(
        publishTo <<= version { (v: String) =>
            val nexus = "https://maven.atlassian.com/"

            if (v.trim.endsWith("SNAPSHOT"))
                Some("snapshots" at nexus + "3rdparty-snapshot")
            else
                Some("releases"  at nexus + "3rdparty")
        }
    )
}
