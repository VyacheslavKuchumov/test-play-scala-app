lazy val root = (project in file("."))
  .enablePlugins(PlayScala, JavaAppPackaging)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend
  .settings(
    name := "play-scala-hello-world-tutorial",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.16", "3.3.6"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test
    ),
    // Make the generated executable script predictable for nixpacks / deployment
    executableScriptName := "main",

    // If you later want to build a Docker image with sbt-native-packager:
    // dockerBaseImage := "eclipse-temurin:17-jre",
    // dockerExposedPorts := Seq(9000),

    // JVM / production options (can be overridden via env or start cmd)
    javaOptions ++= Seq("-Xms256m", "-Xmx1g"),

    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    )
  )
