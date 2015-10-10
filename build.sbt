name := "genbcode-akka-json4s"
organization := "witi83"
version := "0.1"
scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-feature", "-target:jvm-1.8")
scalacOptions ++= Seq("-Yinline-warnings", "-Xfatal-warnings")
scalacOptions ++= Seq("-Ybackend:GenBCode", "-Ydelambdafy:method", "-Yopt:l:classpath")

libraryDependencies ++= {
  val akkaV = "2.4.0"
  val akkaStreamV = "1.0"
  val json4sV = "3.3.0"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-http-core-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaStreamV,
    "com.typesafe.akka" %% "akka-slf4j" % akkaV % Runtime,
    "com.typesafe.akka" %% "akka-stream-experimental" % akkaStreamV,
    "de.heikoseeberger" %% "akka-http-json4s" % "1.1.0",
    "org.json4s" %% "json4s-ast" % json4sV,
    "org.json4s" %% "json4s-ext" % json4sV,
    "org.json4s" %% "json4s-native" % json4sV,
    "org.scala-lang.modules" %% "scala-java8-compat" % "0.7.0"% Runtime,
    "org.scala-lang" % "scala-reflect" % "2.11.7" % Runtime
  )
}

Revolver.settings
