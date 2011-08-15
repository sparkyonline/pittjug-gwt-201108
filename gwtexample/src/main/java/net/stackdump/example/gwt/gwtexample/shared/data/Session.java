package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Status for a single session.
 */
public class Session implements IsSerializable
{
    /**
     * The ID.
     */
    private String id;
    
    /**
     * The session name.
     */
    private String name;
    
    /**
     * The type.
     */
    private SessionType type;
    
    /**
     * The status.
     */
    private String status;
    
    /**
     * Named times.
     */
    private TimeCollection times = new TimeCollection();
    
    /**
     * The timeout.
     */
    private long inactivityTimeout;
    
    /**
     * Emulators for this session.
     */
    private List<Emulator> emulators = new ArrayList<Emulator>();

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
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * @return the type
     */
    public SessionType getType()
    {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final SessionType type)
    {
        this.type = type;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(final String status)
    {
        this.status = status;
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
     * @return the inactivityTimeout
     */
    public long getInactivityTimeout()
    {
        return inactivityTimeout;
    }

    /**
     * @param inactivityTimeout the inactivityTimeout to set
     */
    public void setInactivityTimeout(final long inactivityTimeout)
    {
        this.inactivityTimeout = inactivityTimeout;
    }

    /**
     * @return the emulators
     */
    public List<Emulator> getEmulators()
    {
        return emulators;
    }

    /**
     * @param emulators the emulators to set
     */
    public void setEmulators(final List<Emulator> emulators)
    {
        this.emulators =
            (emulators == null) ? new ArrayList<Emulator>() : emulators;
    }
}
