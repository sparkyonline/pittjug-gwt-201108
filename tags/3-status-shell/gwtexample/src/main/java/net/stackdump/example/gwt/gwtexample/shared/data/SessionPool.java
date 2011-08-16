package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Status for a session pool.
 */
public class SessionPool implements IsSerializable
{
    /**
     * The ID. 
     */
    private String id;
    
    /**
     * Pool name.
     */
    private String name;
    
    /**
     * The pool's maximum size.
     */
    private long maxSize;
    
    /**
     * The pool's minimum size.
     */
    private long minSize;
    
    /**
     * The pool's timeout.
     */
    private long inactivityTimeout;
    
    /**
     * The current number of waiters.
     */
    private long numWaiters;
    
    /**
     * The cumulative waiter count.
     */
    private long totalWaiters;
    
    /**
     * The maximum wait time.
     */
    private long maxWaitTime;
    
    /**
     * The total number of threads.
     */
    private long totalThreads;
    
    /**
     * The average wait time.
     */
    private long averageWaitTime;
    
    /**
     * List of sessions.
     */
    private List<Session> sessions = new ArrayList<Session>();

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
     * @return the maxSize
     */
    public long getMaxSize()
    {
        return maxSize;
    }

    /**
     * @param maxSize the maxSize to set
     */
    public void setMaxSize(final long maxSize)
    {
        this.maxSize = maxSize;
    }

    /**
     * @return the minSize
     */
    public long getMinSize()
    {
        return minSize;
    }

    /**
     * @param minSize the minSize to set
     */
    public void setMinSize(final long minSize)
    {
        this.minSize = minSize;
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
     * @return the numWaiters
     */
    public long getNumWaiters()
    {
        return numWaiters;
    }

    /**
     * @param numWaiters the numWaiters to set
     */
    public void setNumWaiters(final long numWaiters)
    {
        this.numWaiters = numWaiters;
    }

    /**
     * @return the totalWaiters
     */
    public long getTotalWaiters()
    {
        return totalWaiters;
    }

    /**
     * @param totalWaiters the totalWaiters to set
     */
    public void setTotalWaiters(final long totalWaiters)
    {
        this.totalWaiters = totalWaiters;
    }

    /**
     * @return the maxWaitTime
     */
    public long getMaxWaitTime()
    {
        return maxWaitTime;
    }

    /**
     * @param maxWaitTime the maxWaitTime to set
     */
    public void setMaxWaitTime(final long maxWaitTime)
    {
        this.maxWaitTime = maxWaitTime;
    }

    /**
     * @return the totalThreads
     */
    public long getTotalThreads()
    {
        return totalThreads;
    }

    /**
     * @param totalThreads the totalThreads to set
     */
    public void setTotalThreads(final long totalThreads)
    {
        this.totalThreads = totalThreads;
    }

    /**
     * @return the averageWaitTime
     */
    public long getAverageWaitTime()
    {
        return averageWaitTime;
    }

    /**
     * @param averageWaitTime the averageWaitTime to set
     */
    public void setAverageWaitTime(final long averageWaitTime)
    {
        this.averageWaitTime = averageWaitTime;
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
}
