name := "rest-api-hello-world"
version := "0.1"
scalaVersion := "2.12.4"


val Http4sVersion = "0.16.0a"

libraryDependencies ++= Seq(
  "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"     %% "http4s-circe"        % Http4sVersion,
  "org.http4s"     %% "http4s-dsl"          % Http4sVersion
)