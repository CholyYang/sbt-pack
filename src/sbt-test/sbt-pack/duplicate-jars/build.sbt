val commonSettings = Defaults.defaultSettings ++ Seq(
  scalaVersion := "2.11.8",
  version := "0.1",
  crossPaths := false
)

lazy val root = Project(
  id = "duplicate-jars",
  base = file("."),
  settings = commonSettings ++
    Seq(
      // custom settings here
    )
)
.enablePlugins(PackPlugin)
.dependsOn(module1, module2)

lazy val module1 = Project(
  id = "module1",
  base = file("module1"),
  settings = commonSettings ++ Seq(
    libraryDependencies ++= Seq(
      "org.xerial" % "xerial-core" % "3.3.6",
      "org.slf4j" % "slf4j-api" % "1.7.2" force()
    )
  )
)

lazy val module2 = Project(
  id = "module2",
  base = file("module2"),
  settings = commonSettings ++ Seq(
    libraryDependencies ++= Seq(
      "org.xerial.snappy" % "snappy-java" % "1.1.1.6",
      "org.slf4j" % "slf4j-api" % "1.7.6"
    )
  )
)
