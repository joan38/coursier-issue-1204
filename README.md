# Coursier and Ivy => None.get issue reproduction

This project is to reproduce the issue mentioned in https://github.com/coursier/coursier/issues/1204
```
# rm -rf ~/.ivy2/cache/com.netflix.karyon/
# sbt update
[info] Loading global plugins from /Users/jgoyeau/.sbt/1.0/plugins
[info] Loading project definition from /Users/jgoyeau/IdeaProjects/coursier-issue-1204/project
[info] Loading settings for project coursier-issue-1204 from build.sbt ...
[info] Set current project to Coursier Issue 1204 (in build file:/Users/jgoyeau/IdeaProjects/coursier-issue-1204/)
[info] Welcome to sbt 1.3.0-RC2.
[info] Here are some highlights of this release:
[info]   - Coursier: new default library management using https://get-coursier.io
[info]   - Super shell: displays actively running tasks
[info]   - Turbo mode: makes `test` and `run` faster in interactive sessions. Try it by running `set ThisBuild / turbo := true`.
[info] See https://www.lightbend.com/blog/sbt-1.3.0-release for full release notes.
[info] Hide the banner for this release by running `skipBanner`.
[warn] sbt server could not start because there's another instance of sbt running on this build.
[warn] Running multiple instances is unsupported
sbt:Coursier Issue 1204> update
[error] java.util.NoSuchElementException: None.get
[error]         at scala.None$.get(Option.scala:366)
[error]         at scala.None$.get(Option.scala:364)
[error]         at lmcoursier.internal.shaded.coursier.maven.PomParser$$anon$5.end(PomParser.scala:517)
[error]         at lmcoursier.internal.shaded.coursier.maven.PomParser.$anonfun$endElement$1(PomParser.scala:53)
[error]         at lmcoursier.internal.shaded.coursier.maven.PomParser.$anonfun$endElement$1$adapted(PomParser.scala:47)
[error]         at scala.Option.foreach(Option.scala:274)
[error]         at lmcoursier.internal.shaded.coursier.maven.PomParser.endElement(PomParser.scala:47)
[error]         at lmcoursier.internal.shaded.coursier.core.compatibility.package$XmlHandler.endElement(package.scala:48)
[error]         at com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.endElement(AbstractSAXParser.java:609)
[error]         at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanEndElement(XMLDocumentFragmentScannerImpl.java:1782)
[error]         at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl$FragmentContentDriver.next(XMLDocumentFragmentScannerImpl.java:2967)
[error]         at com.sun.org.apache.xerces.internal.impl.XMLDocumentScannerImpl.next(XMLDocumentScannerImpl.java:602)
[error]         at com.sun.org.apache.xerces.internal.impl.XMLDocumentFragmentScannerImpl.scanDocument(XMLDocumentFragmentScannerImpl.java:505)
[error]         at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:842)
[error]         at com.sun.org.apache.xerces.internal.parsers.XML11Configuration.parse(XML11Configuration.java:771)
[error]         at com.sun.org.apache.xerces.internal.parsers.XMLParser.parse(XMLParser.java:141)
[error]         at com.sun.org.apache.xerces.internal.parsers.AbstractSAXParser.parse(AbstractSAXParser.java:1213)
[error]         at com.sun.org.apache.xerces.internal.jaxp.SAXParserImpl$JAXPSAXParser.parse(SAXParserImpl.java:643)
[error]         at lmcoursier.internal.shaded.coursier.core.compatibility.package$.xmlParseSax(package.scala:64)
[error]         at lmcoursier.internal.shaded.coursier.maven.MavenRepository$.parseRawPomSax(MavenRepository.scala:70)
[error]         at lmcoursier.internal.shaded.coursier.maven.MavenRepository.$anonfun$findVersioning$1(MavenRepository.scala:358)
[error]         at lmcoursier.internal.shaded.coursier.util.EitherT.$anonfun$flatMap$1(EitherT.scala:16)
[error]         at lmcoursier.internal.shaded.coursier.util.Task$.$anonfun$flatMap$2(Task.scala:11)
[error]         at scala.concurrent.Future.$anonfun$flatMap$1(Future.scala:307)
[error]         at scala.concurrent.impl.Promise.$anonfun$transformWith$1(Promise.scala:41)
[error]         at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:64)
[error]         at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
[error]         at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
[error]         at java.lang.Thread.run(Thread.java:748)
[error] (update) java.util.NoSuchElementException: None.get
[error] Total time: 0 s, completed Jun 12, 2019 4:09:44 PM
```