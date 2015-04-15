# Introduction #

I had a need to gather status information from many different servers, with the ultimate need of finding and acting on specific pieces of information, in a semi-automated fashion.


# Details #

Some information about the type of status data I had:

  * Formatted in XML.  No schema, but format easily consumed.
  * Many servers and instances would return their version of this XML data.
  * Need to be able to aggregate this data across all instances, to be able to react more efficiently than having to manage each instance independently.

I wanted to learn something about GWT while creating an app that can show the data from all instances together:
  * in a tabular format
  * in a hierarchy

In addition, I wanted to test out some features of the GWT stack and build process:
  * Localized Text
  * GWT Designer (WindowBuilder)
  * Maven Packaging
  * Any other information I could glean along the way

To better leverage the designer, I decided to replace the entire body of the host HTML page with a composite widget, which would then give me a more WYSIWYG feel.

To put this together:
  * Convert the example app into a shell for the status tool, with a toolbar and a tab panel for different views.
  * Create an asynchronous service that can return status information.
  * Populate a table with the info.
  * Populate a tree with the info.