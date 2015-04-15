# Introduction #

An overview of adding and consuming an asynchronous service.


# Details #

GWT generates code that enables this in a clean manner.  You define an interface representing the content of the service, and the plugin fills in the rest, including updating the web.xml for you.  The build creates the plumbing, and allows you to consume this service using a callback on the client.

  * Right-click the project and choose Google Web Toolkit > GWT Remote Service.
  * Select the client package and give the service a name:<br><img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-new-async-service.png'></li></ul>

This will generate:
  * The service interface
  * An Async version of the interface, that will be updated to take callback implementations for all new main interface methods.
  * An implementation class in the server package.
  * Appropriate markup in the web.xml to expose the service's servlet.