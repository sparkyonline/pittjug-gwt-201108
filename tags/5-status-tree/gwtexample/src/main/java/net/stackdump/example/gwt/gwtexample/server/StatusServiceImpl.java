package net.stackdump.example.gwt.gwtexample.server;

import net.stackdump.example.gwt.gwtexample.client.StatusService;
import net.stackdump.example.gwt.gwtexample.shared.data.Environment;
import net.stackdump.example.gwt.gwtexample.shared.data.Instance;
import net.stackdump.example.gwt.gwtexample.shared.data.InstanceIdentifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StatusServiceImpl extends RemoteServiceServlet implements StatusService {

  private static final long serialVersionUID = 1L;

  @Override
  public Environment getStatus()
  {
    final Environment env = new Environment();
    
    final InstanceStatusRetriever retriever = new InstanceStatusRetriever();
    final Instance instance = retriever.getInstanceStatus();
    
    final InstanceIdentifier id = new InstanceIdentifier("dummy host",
        "dummy instance");
    instance.setInstanceIdentifier(id);
    env.put(id, instance);
    
    return env;
  }
}
