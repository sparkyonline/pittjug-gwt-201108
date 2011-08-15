package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Status for a particular organization.
 */
public class Organization implements IsSerializable
{
    /**
     * The ID.
     */
    private String id;
    
    /**
     * The name.
     */
    private String name;
    
    /**
     * Sessions.
     */
    private List<Session> sessions = new ArrayList<Session>();
    
    /**
     * Session pools.
     */
    private List<SessionPool> sessionPools = new ArrayList<SessionPool>();

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
     * @return the sessions
     */
    public List<Session> getSessions()
    {
        return sessions;
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(final List<Session> sessions)
    {
        this.sessions =
            (sessions == null) ? new ArrayList<Session>() : sessions;
    }

    /**
     * @return the sessionPools
     */
    public List<SessionPool> getSessionPools()
    {
        return sessionPools;
    }

    /**
     * @param sessionPools the sessionPools to set
     */
    public void setSessionPools(final List<SessionPool> sessionPools)
    {
        this.sessionPools =
            (sessionPools == null) ? new ArrayList<SessionPool>()
                : sessionPools;
    }
}
