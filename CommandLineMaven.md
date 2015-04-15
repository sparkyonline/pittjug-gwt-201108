# Introduction #

Utilizing the command-line, maven support to create and launch GWT projects.

# Details #

## GWT Maven Plugin Archetype ##

There is an [archetype](http://mojo.codehaus.org/gwt-maven-plugin/user-guide/archetype.html) to aid in creation of GWT projects:

```
C:\PittJUG Presentation\pittjug-gwt-201108>mvn --batch-mode ^
More? archetype:generate ^
More? -DarchetypeRepository=repo1.maven.org ^
More? -DarchetypeGroupId=org.codehaus.mojo ^
More? -DarchetypeArtifactId=gwt-maven-plugin ^
More? -DarchetypeVersion=2.3.0-1 ^
More? -DgroupId=net.stackdump.example.gwt ^
More? -DartifactId=gwtexample ^
More? -Dversion=1.0-SNAPSHOT ^
More? -Dpackage=net.stackdump.example.gwt.gwtexample ^
More? -Dmodule=GWTExample
[INFO] Scanning for projects...
[INFO] Searching repository for plugin with prefix: 'archetype'.
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Default Project
[INFO]    task-segment: [archetype:generate] (aggregator-style)
[INFO] ------------------------------------------------------------------------
[INFO] Preparing archetype:generate
[INFO] No goals needed for project - skipping
[INFO] [archetype:generate {execution: default-cli}]
[INFO] Generating project in Batch mode
[INFO] Archetype defined by properties
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1 second
[INFO] Finished at: Sun Aug 14 15:20:42 EDT 2011
[INFO] Final Memory: 12M/245M
[INFO] ------------------------------------------------------------------------
```

## Tweaks to the Initial POM ##

I made some tweaks to the initial POM to get rid of some warnings, etc.  There used to be more with prior versions of the archetype, but now I find it to be a small list:

  * Changed `maven.compiler.source` and `maven.compiler.target` to `1.6`.

## Packaging a WAR ##

The standard `package` command will trigger the initial GWT processing, producing a war:

```
C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample>mvn package
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building GWT Maven Archetype
[INFO]    task-segment: [package]
[INFO] ------------------------------------------------------------------------
[INFO] [gwt:i18n {execution: default}]
[INFO] [gwt:generateAsync {execution: default}]
[INFO] [resources:resources {execution: default-resources}]
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO] [compiler:compile {execution: default-compile}]
[INFO] Compiling 6 source files to C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT\WEB-INF\classes
[INFO] [war:exploded {execution: default}]
[INFO] Exploding webapp
[INFO] Assembling webapp [gwtexample] in [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\src\main\webapp]
[INFO] Webapp assembled in [71 msecs]
[INFO] [resources:testResources {execution: default-testResources}]
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] [compiler:testCompile {execution: default-testCompile}]
[INFO] Compiling 1 source file to C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\test-classes
[INFO] [surefire:test {execution: default-test}]
[INFO] Surefire report directory: C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
There are no tests to run.

Results :

Tests run: 0, Failures: 0, Errors: 0, Skipped: 0

[INFO] [gwt:compile {execution: default}]
[INFO] auto discovered modules [net.stackdump.example.gwt.gwtexample.GWTExample]
[INFO] Compiling module net.stackdump.example.gwt.gwtexample.GWTExample
[INFO]    Compiling 6 permutations
[INFO]       Compiling permutation 5...
[INFO]       Process output
[INFO]          Compiling
[INFO]             Compiling permutation 4...
[INFO]       Process output
[INFO]          Compiling
[INFO]             Compiling permutation 1...
[INFO]       Process output
[INFO]          Compiling
[INFO]             Compiling permutation 0...
[INFO]       Process output
[INFO]          Compiling
[INFO]             Compiling permutation 3...
[INFO]       Process output
[INFO]          Compiling
[INFO]             Compiling permutation 2...
[INFO]    Compile of permutations succeeded
[INFO] Linking into C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT\GWTExample
[INFO]    Link succeeded
[INFO]    Compilation succeeded -- 45.536s
[INFO] [war:war {execution: default-war}]
[INFO] Packaging webapp
[INFO] Assembling webapp [gwtexample] in [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\src\main\webapp]
[INFO] Webapp assembled in [55 msecs]
[INFO] Building war: C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT.war
[WARNING] Warning: selected war files include a WEB-INF/web.xml which will be ignored
(webxml attribute is missing from war task, or ignoreWebxml attribute is specified as 'true')
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 54 seconds
[INFO] Finished at: Sun Aug 14 15:41:37 EDT 2011
[INFO] Final Memory: 36M/493M
[INFO] ------------------------------------------------------------------------
```

## Launching Hosted Mode ##

The plugin can also use an embedded Jetty to launch "hosted mode" for local testing:

```
C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample>mvn gwt:run
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Building GWT Maven Archetype
[INFO]    task-segment: [gwt:run]
[INFO] ------------------------------------------------------------------------
[INFO] Preparing gwt:run
[INFO] [gwt:i18n {execution: default}]
[INFO] [gwt:generateAsync {execution: default}]
[INFO] [resources:resources {execution: default-resources}]
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO] [compiler:compile {execution: default-compile}]
[INFO] Compiling 1 source file to C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT\WEB-INF\classes
[INFO] [war:exploded {execution: default}]
[INFO] Exploding webapp
[INFO] Assembling webapp [gwtexample] in [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT]
[INFO] Processing war project
[INFO] Copying webapp resources [C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\src\main\webapp]
[INFO] Webapp assembled in [67 msecs]
[INFO] [gwt:run {execution: default-cli}]
[INFO] create exploded Jetty webapp in C:\PittJUG Presentation\pittjug-gwt-201108\gwtexample\target\gwtexample-1.0-SNAPSHOT
[INFO] auto discovered modules [net.stackdump.example.gwt.gwtexample.GWTExample]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1 minute 43 seconds
[INFO] Finished at: Sun Aug 14 15:49:32 EDT 2011
[INFO] Final Memory: 30M/495M
[INFO] ------------------------------------------------------------------------
```

<img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/gwt-run-hosted-mode.png'>