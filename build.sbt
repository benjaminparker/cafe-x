organization := "com.needstyping"
scalaVersion := "2.12.5"
version := "0.1.0-SNAPSHOT"

name := "cafe-x"
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.1.0" % "test")
scalacOptions in Test ++= Seq("-Yrangepos")
