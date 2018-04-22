lazy val `rest-api-hello-world` =
  project
    .in(file("."))
    .enablePlugins(GitVersioning, DockerPlugin, JavaAppPackaging)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
        "org.http4s" %% "http4s-circe" % Http4sVersion,
        "org.http4s" %% "http4s-dsl" % Http4sVersion
      )
    )

val Http4sVersion = "0.16.0a"

lazy val settings =
  commonSettings ++
    gitSettings ++
    dockerSettings

lazy val commonSettings =
  Seq(
    organization := "com.nolanofra",
    organizationName := "Francesco Nolano",
    startYear := Some(2018),
    scalaVersion := "2.12.4",
    mainClass := Some("Main"),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding",
      "UTF-8"
    ),
    unmanagedSourceDirectories.in(Compile) := Seq(scalaSource.in(Compile).value),
    unmanagedSourceDirectories.in(Test) := Seq(scalaSource.in(Test).value),
    publishArtifact.in(Compile, packageDoc) := false,
    publishArtifact.in(Compile, packageSrc) := false
  )
lazy val gitSettings =
  Seq(
    git.useGitDescribe := true
  )

lazy val dockerSettings =
  Seq(
    version.in(Docker) := "latest",
    dockerBaseImage := "openjdk:8u151-slim",
    dockerExposedPorts := Vector(8080),
  )