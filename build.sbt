enablePlugins(ScalaNativePlugin)

scalaVersion := "2.11.11"

version := {
  val versionFile = scala.io.Source.fromFile("VERSION")
  try {
    versionFile.mkString.trim
  } finally {
    versionFile.close()
  }
}

fork in run := true
