name := "scala-check-presentation"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.0"

testOptions in Test += Tests.Argument(TestFrameworks.ScalaCheck,"-minSuccessfulTests", "100", "-maxDiscardRatio","10")
