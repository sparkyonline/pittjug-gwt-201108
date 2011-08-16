package net.stackdump.example.gwt.gwtexample.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Data to identify a particular instance;
 */
public class InstanceIdentifier implements IsSerializable
{
    /**
     * The host the instance is running on.
     */
    private String host;
    
    /**
     * The name of the instance.
     */
    private String instance;
    
    /**
     * Default constructor.
     */
    public InstanceIdentifier()
    {
        this(null, null);
    }
    
    /**
     * Constructor.
     * 
     * @param host The host.
     * @param instanceName The instance name.
     */
    public InstanceIdentifier(final String host, final String instanceName)
    {
        this.host = host;
        this.instance = instanceName;
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
     * @return the instance
     */
    public String getInstance()
    {
        return instance;
    }

    /**
     * @param instance the instance to set
     */
    public void setInstance(final String instance)
    {
        this.instance = instance;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result =
            prime * result + ((instance == null) ? 0 : instance.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final InstanceIdentifier other = (InstanceIdentifier) obj;
        if (host == null)
        {
            if (other.host != null)
            {
                return false;
            }
        }
        else if (!host.equals(other.host))
        {
            return false;
        }
        if (instance == null)
        {
            if (other.instance != null)
            {
                return false;
            }
        }
        else if (!instance.equals(other.instance))
        {
            return false;
        }
        return true;
    }
}
