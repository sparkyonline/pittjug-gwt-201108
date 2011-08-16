package net.stackdump.example.gwt.gwtexample.client;

import net.stackdump.example.gwt.gwtexample.shared.data.SessionType;

import com.google.gwt.view.client.ProvidesKey;

public class EmulatorRecord
{
    /**
     * Key provider for emulator records.
     */
    public static final ProvidesKey<EmulatorRecord> KEY_PROVIDER = new ProvidesKey<EmulatorRecord>()
    {
        @Override
        public Object getKey(final EmulatorRecord item)
        {
            return item == null ? null : item.getID();
        }
    };
    
    private int id;
    private String host;
    private String instanceName;
    private String orgName;
    private String sessionName;
    private SessionType sessionType;
    private String emuSystem;
    private String emuCurrentScreen;
    
    public int getID()
    {
        return id;
    }
    public void setID(final int id)
    {
        this.id = id;
    }
    
    /**
     * @return the host
     */
    public String getHost()
    {
        return host;
    }
    /**
     * @param host the host to set
     */
    public void setHost(final String host)
    {
        this.host = host;
    }
    /**
     * @return the instanceName
     */
    public String getInstanceName()
    {
        return instanceName;
    }
    /**
     * @param instanceName the instanceName to set
     */
    public void setInstanceName(final String instanceName)
    {
        this.instanceName = instanceName;
    }
    /**
     * @return the orgName
     */
    public String getOrgName()
    {
        return orgName;
    }
    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(final String orgName)
    {
        this.orgName = orgName;
    }
    /**
     * @return the sessionName
     */
    public String getSessionName()
    {
        return sessionName;
    }
    /**
     * @param sessionName the sessionName to set
     */
    public void setSessionName(final String sessionName)
    {
        this.sessionName = sessionName;
    }
    /**
     * @return the sessionType
     */
    public SessionType getSessionType()
    {
        return sessionType;
    }
    /**
     * @param sessionType the sessionType to set
     */
    public void setSessionType(final SessionType sessionType)
    {
        this.sessionType = sessionType;
    }
    /**
     * @return the emuSystem
     */
    public String getEmuSystem()
    {
        return emuSystem;
    }
    /**
     * @param emuSystem the emuSystem to set
     */
    public void setEmuSystem(final String emuSystem)
    {
        this.emuSystem = emuSystem;
    }
    /**
     * @return the emuCurrentScreen
     */
    public String getEmuCurrentScreen()
    {
        return emuCurrentScreen;
    }
    /**
     * @param emuCurrentScreen the emuCurrentScreen to set
     */
    public void setEmuCurrentScreen(final String emuCurrentScreen)
    {
        this.emuCurrentScreen = emuCurrentScreen;
    }
}
