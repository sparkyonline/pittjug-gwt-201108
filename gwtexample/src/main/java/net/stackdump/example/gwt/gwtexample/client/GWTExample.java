package net.stackdump.example.gwt.gwtexample.client;

import static com.google.gwt.dom.client.Style.Unit.PX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.stackdump.example.gwt.gwtexample.shared.data.Emulator;
import net.stackdump.example.gwt.gwtexample.shared.data.Environment;
import net.stackdump.example.gwt.gwtexample.shared.data.Instance;
import net.stackdump.example.gwt.gwtexample.shared.data.InstanceIdentifier;
import net.stackdump.example.gwt.gwtexample.shared.data.Organization;
import net.stackdump.example.gwt.gwtexample.shared.data.Session;
import net.stackdump.example.gwt.gwtexample.shared.data.SessionPool;
import net.stackdump.example.gwt.gwtexample.shared.data.SessionType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

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
   * List that will provide information about an emulator.
   */
  private final ListDataProvider<EmulatorRecord> emuList = new ListDataProvider<EmulatorRecord>(
      EmulatorRecord.KEY_PROVIDER);
  
  /**
   * The list of emulator records, as parsed from the response.
   */
  private List<EmulatorRecord> origEmuList;
  
  /**
   * The most recently obtained environment status information.
   */
  private Environment environment;

  private EmulatorTable emulatorTable;

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
            updateEmulators(env);
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
    clearButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        origEmuList.clear();
        resetList();
      }
    });
    toolbarPanel.add(clearButton);
    
    TabLayoutPanel tabPanel = new TabLayoutPanel(1.5, Unit.EM);
    
    SimplePanel tablePanel = new SimplePanel();
    tabPanel.add(tablePanel, messages.tableTab(), false);
    
    ScrollPanel scrollPanel = new ScrollPanel();
    tablePanel.setWidget(scrollPanel);
    scrollPanel.setSize("100%", "100%");
    
    emulatorTable = new EmulatorTable(emuList);
    scrollPanel.setWidget(emulatorTable);
    emulatorTable.setSize("100%", "100%");
    
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
  
  /**
   * Uses the response to update the UI.
   * 
   * @param env The retrieved environment status information.
   */
  private void updateEmulators(final Environment env)
  {
    final List<EmulatorRecord> records = new ArrayList<EmulatorRecord>();
    
    String host;
    String instanceName;
    String orgName;
    String sessionName;
    SessionType sessionType;
    String emuSystem;
    String emuCurrentScreen;
    
    InstanceIdentifier id;
    Instance instance;
    EmulatorRecord record;
    
    int nextID = 0;
    for (Map.Entry<InstanceIdentifier, Instance> envEntry : env.entrySet())
    {
        id = envEntry.getKey();
        host = id.getHost();
        instanceName = id.getInstance();
        instance = envEntry.getValue();
        
        for (Organization org : instance.getOrganizations())
        {
            orgName = org.getName();
            
            for (Session session : org.getSessions())
            {
                sessionName = session.getName();
                sessionType = session.getType();
                for (Emulator emu : session.getEmulators())
                {
                    emuSystem = emu.getSystem();
                    emuCurrentScreen = emu.getCurrentScreen();
                    
                    record = new EmulatorRecord();
                    record.setID(nextID++);
                    record.setHost(host);
                    record.setInstanceName(instanceName);
                    record.setOrgName(orgName);
                    record.setSessionName(sessionName);
                    record.setSessionType(sessionType);
                    record.setEmuSystem(emuSystem);
                    record.setEmuCurrentScreen(emuCurrentScreen);
                    
                    records.add(record);
                }
            }
            
            for (SessionPool pool : org.getSessionPools())
            {
                for (Session session : pool.getSessions())
                {
                    sessionName = session.getName();
                    sessionType = session.getType();
                    for (Emulator emu : session.getEmulators())
                    {
                        emuSystem = emu.getSystem();
                        emuCurrentScreen = emu.getCurrentScreen();
                        
                        record = new EmulatorRecord();
                        record.setID(nextID++);
                        record.setHost(host);
                        record.setInstanceName(instanceName);
                        record.setOrgName(orgName);
                        record.setSessionName(sessionName);
                        record.setSessionType(sessionType);
                        record.setEmuSystem(emuSystem);
                        record.setEmuCurrentScreen(emuCurrentScreen);
                        
                        records.add(record);
                    }
                }
            }
        }
    }
    
    origEmuList = records;
    environment = env;
    resetList();
  }
  
  /**
   * Resets the displayed information.
   */
  private void resetList()
  {
    if (origEmuList != null)
    {
      emuList.getList().clear();
      emulatorTable.getTable().getColumnSortList().clear();
      emuList.getList().addAll(origEmuList);
      emulatorTable.getTable().setVisibleRange(0, origEmuList.size());
    }
  }
}
