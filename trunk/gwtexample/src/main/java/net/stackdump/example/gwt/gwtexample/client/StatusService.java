package net.stackdump.example.gwt.gwtexample.client;

import net.stackdump.example.gwt.gwtexample.shared.data.Environment;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("StatusService")
public interface StatusService extends RemoteService {
	
  /**
   * Get the current status for the environment.
   * @return The environment's status data.
   */
  public Environment getStatus();
  
  /**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static StatusServiceAsync instance;
		public static StatusServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(StatusService.class);
			}
			return instance;
		}
	}
}
