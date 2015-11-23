name := "openVoting-scala"

organization := "com.forged"

version := "0.1"

scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.3.9"
  val sprayV      = "1.3.3"
  val sprayJsonV  = "1.3.2"
  val mongodbV    = "1.0.1"

  Seq(
    "io.spray"            %%  "spray-can"           % sprayV,
    "io.spray"            %%  "spray-routing"       % sprayV,
    "io.spray"            %%  "spray-json"          % sprayJsonV,
    "io.spray"            %%  "spray-testkit"       % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"          % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"        % akkaV   % "test",
    "org.mongodb.scala"   %%  "mongo-scala-driver"  % mongodbV
//    "org.specs2"          %%  "specs2-core"   % "2.3.7" % "test"
  )
}

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

TwirlKeys.templateImports += "java.util.UUID"

TwirlKeys.templateImports += "com.forged._"

Revolver.settings