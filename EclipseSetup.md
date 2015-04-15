# Introduction #

There are a few plugins/settings for Eclipse that are necessary before diving in with the mavenized GWT project we just generated.


# Details #

## Prepare Eclipse ##

  * Assumption: WTP already set up with a Server
  * [m2Eclipse Core](http://m2eclipse.sonatype.org/installing-m2eclipse.html) from the [core update site](http://m2eclipse.sonatype.org/sites/m2e) for Maven Integration
  * [m2Eclipse Extras](http://m2eclipse.sonatype.org/installing-m2eclipse.html) from the [extras update site](http://m2eclipse.sonatype.org/sites/m2e-extras) for Maven WTP Integration
  * [Google Plugin for Eclipse](http://code.google.com/eclipse/docs/download.html) from the [update site](http://dl.google.com/eclipse/plugin/3.7) for the Google-provided functionality and SDKs.  (Leave out the GWT Designer for now, so we can install the full-fledged version next.)
  * [GWT Designer](http://code.google.com/webtoolkit/tools/download-gwtdesigner.html) from [its update site](http://dl.google.com/eclipse/inst/d2gwt/latest/3.7) to get the complete build of the designer.
  * Update Eclipse configuration to execute `process-resources` maven goal on import:<br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-import-process-resources.png'></li></ul>

## Import the Project ##

  * Import... Maven > Existing Maven Projects:<br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-import-existing-maven-project.png'><br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-import-pom.png'>
<ul><li>Google provides <a href='http://code.google.com/intl/en/eclipse/docs/faq.html'>FAQ</a> entries on using <a href='http://code.google.com/intl/en/eclipse/docs/faq.html#gwt_in_eclipse_for_java_ee'>WTP</a> and on using <a href='http://code.google.com/intl/en/eclipse/docs/faq.html#gwt_with_maven'>Maven</a> with GWT projects.<br>
</li><li>Add the Dynamic Web Project you just imported to your Server.  Server should launch successfully at this point.<br>
</li><li>In the project's build path, remove the "" exclusion for the main and test resources folders.  This later allows the modules to be detected automatically.<br>
</li><li>In the project's context menu, select Google > Web Toolkit Settings... and check "Use Google Web Toolkit".  Then, ensure the entry point modules are detected:<br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-use-google-web-toolkit.png'>
</li><li>Still within the Google settings, under Web Application, uncheck the box for launching and deploying from the WAR directory.<br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-do-not-launch-from-war-directory.png'>
</li><li>Since we will be launching using the WTP Server, we now need to create the launch target for hosted mode.  Create a new launch configuration for a Web Application, unchecking the built-in, embedded server option, and entering the URL for the webapp within the server, appending the host HTML page.  For this example, it will be: <a href='http://localhost:8080/gwtexample/GWTExample.html'>http://localhost:8080/gwtexample/GWTExample.html</a>
</li><li>As the FAQ indicates, you will be prompted to select your exploded WAR folder under the tmp area within the workspace, the first time you launch the web application target.  For this example, that path is: ...\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\gwtexample</li></ul>

At this point, we can launch our WTP server, then launch the GWT Web Application, and debug, hitting breakpoints on both the client and server side.