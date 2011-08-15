package net.stackdump.example.gwt.gwtexample.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Status of an emulator.
 */
public class Emulator implements IsSerializable
{
    /**
     * The ID.
     */
    private String id;
    
    /**
     * System the emulator is tied to.
     */
    private String system;
    
    /**
     * The emulator's current screen.
     */
    private String currentScreen;
    
    /**
     * The times associated with this emulator.
     */
    private TimeCollection times = new TimeCollection();
    
    /**
     * The emulator's terminal ID.
     */
    private String terminalID;
    
    /**
     * The emulator's node name.
     */
    private String nodeName;

    /**
     * @return the id
     */
    public String getID()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(final String id)
    {
        this.id = id;
    }

    /**
     * @return the system
     */
    public String getSystem()
    {
        return system;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(final String system)
    {
        this.system = system;
    }

    /**
     * @return the currentScreen
     */
    public String getCurrentScreen()
    {
        return currentScreen;
    }

    /**
     * @param currentScreen the currentScreen to set
     */
    public void setCurrentScreen(final String currentScreen)
    {
        this.currentScreen = currentScreen;
    }

    /**
     * @return the times
     */
    public TimeCollection getTimes()
    {
        return times;
    }

    /**
     * @param times the times to set
     */
    public void setTimes(final TimeCollection times)
    {
        this.times = (times == null) ? new TimeCollection() : times;
    }

    /**
     * @return the terminalID
     */
    public String getTerminalID()
    {
        return terminalID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setTerminalID(final String terminalID)
    {
        this.terminalID = terminalID;
    }

    /**
     * @return the nodeName
     */
    public String getNodeName()
    {
        return nodeName;
    }

    /**
     * @param nodeName the nodeName to set
     */
    public void setNodeName(final String nodeName)
    {
        this.nodeName = nodeName;
    }
}
