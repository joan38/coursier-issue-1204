name := "Coursier Issue 1204"
scalaVersion := "2.12.8"
crossScalaVersions := Seq(scalaVersion.value, "2.11.12")
Global / onChangedBuildSource := ReloadOnSourceChanges
turbo := true

val localPattern = Patterns(
  Vector("[module]-[revision]-ivy.[ext]"),
  Vector("[artifact]-[revision](-[classifier]).[ext]"),
  isMavenCompatible = false,
  descriptorOptional = false,
  skipConsistencyCheck = true
)
//useCoursier := false

resolvers := Seq(
  Resolver.url("Local Ivy",  url(s"file://${baseDirectory.value}/ivy"))(localPattern)
)
libraryDependencies ++= Seq(
  "netflix" % "some-lib" % "4.7.26"
)
