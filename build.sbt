import com.earldouglas.xsbtwebplugin.WebPlugin._
import spray.revolver.RevolverPlugin.Revolver

name := "spray spring jetty with war"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

sbtVersion := "0.13.1"

resolvers += "SpringSource Milestone Repository" at "http://repo.springsource.org/milestone"

seq(webSettings : _*)
val akkaV = "2.3.9"
val sprayV = "1.3.3"
libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "4.1.5.RELEASE",
  "org.springframework.scala" % "spring-scala" % "1.0.0.M2" exclude( "org.springframework" , "spring-context"),
  "org.springframework.data" % "spring-data-mongodb" % "1.6.2.RELEASE",
  "io.spray"            %%  "spray-servlet" % sprayV,
  "io.spray"            %%  "spray-routing" % sprayV,
  "io.spray"            %%  "spray-testkit" % sprayV  % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
  "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
  "org.springframework.data" % "spring-data-mongodb" % "1.6.2.RELEASE",
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container, compile",
  "org.eclipse.jetty" % "jetty-jsp" % "9.1.0.v20131115" % "container",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.0"
)

Revolver.settings
