package net.stackdump.example.gwt.gwtexample.server;

import net.stackdump.example.gwt.gwtexample.client.StatusService;
import net.stackdump.example.gwt.gwtexample.shared.data.Environment;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class StatusServiceImpl extends RemoteServiceServlet implements StatusService {

  private static final long serialVersionUID = 1L;

  @Override
  public Environment getStatus()
  {
    // TODO Auto-generated method stub
    return null;
  }
}
