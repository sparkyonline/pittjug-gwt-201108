package net.stackdump.example.gwt.gwtexample.client;

import static com.google.gwt.dom.client.Style.Unit.PX;
import net.stackdump.example.gwt.gwtexample.shared.data.Environment;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTExample implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  
  /**
   * Create a remote service proxy to talk to the server-side Status service. 
   */
  private final StatusServiceAsync statusService = GWT.create(StatusService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    
    // http://code.google.com/webtoolkit/doc/1.6/FAQ_UI.html#How_do_I_create_an_app_that_fills_the_page_vertically_when_the_b
    
    final VerticalPanel resizePanel = new VerticalPanel();
    resizePanel.setWidth("100%");
    resizePanel.setHeight(Window.getClientHeight() + "px");
    
    final DockLayoutPanel mainPanel = new DockLayoutPanel(PX);
    mainPanel.setSize("100%", "100%");
    resizePanel.add(mainPanel);
    
    FlowPanel toolbarPanel = new FlowPanel();
    mainPanel.addNorth(toolbarPanel, 35.0);
    toolbarPanel.setSize("100%", "35");
    
    Button getStatusButton = new Button(messages.getStatusButton());
    getStatusButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        statusService.getStatus(new AsyncCallback<Environment>() {
          
          @Override
          public void onSuccess(final Environment env)
          {
            Object o = env.getMap();
          }
          
          @Override
          public void onFailure(final Throwable e)
          {
            Window.alert("Error: " + e);
          }
        });
      }
    });
    toolbarPanel.add(getStatusButton);
    
    Button clearButton = new Button(messages.clearButton());
    toolbarPanel.add(clearButton);
    
    TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    
    SimplePanel tablePanel = new SimplePanel();
    tabPanel.add(tablePanel, messages.tableTab(), false);
    
    SimplePanel treePanel = new SimplePanel();
    tabPanel.add(treePanel, messages.treeTab(), false);
    mainPanel.add(tabPanel);
    Window.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(final ResizeEvent event)
      {
        resizePanel.setHeight(event.getHeight() + "px");
      }
    });
    RootLayoutPanel.get().clear();
    RootLayoutPanel.get().add(resizePanel);
  }
}
