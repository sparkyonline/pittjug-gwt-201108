# Introduction #

The Google Eclipse plugin ships with a lite version of Windowbuilder's GWT designer, but you can still install the full version separately.


# Details #

Since we installed the full-blown version of the GWT Designer (WindowBuilder), we can use it to inspect and edit our GWT modules.

  * Navigate to the client Entry Point class in Project/Package Explorer.
  * Right-click the class, and select Open With > WindowBuilder Editor.
  * This is a standard Java class editor, with an additional tab at the bottom to switch to "Design" view:
<img src='http://pittjug-gwt-201108.googlecode.com/svn/wiki/eclipse-windowbuilder-design-example.png'></li></ul>

Note that the graphical view does not depict exactly the layout of the real page.  This is due to the fact that the example searches for specific IDs within the host pages, and inserts widgets into more than one.  The designer has no way of knowing the ultimate layout of the host page, so the best it can do is present the controls in the order they are declared, one after another.<br>
<br>
In a later example, we will see the alternative, which is using a single widget to replace the entire body of the page.  In this case, the designer will show that single widget, and the layout within it will accurately reflect that of the deployed application.