package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Represents a server element from within the system status response.
 */
public class Instance implements IsSerializable
{
    /**
     * The host/instance names for this instance.
     */
    private InstanceIdentifier instanceIdentifier;
    
    /**
     * The server ID.
     */
    private String id;

    /**
     * The name.
     */
    private String name;

    /**
     * The address.
     */
    private String address;

    /**
     * The version of the application.
     */
    private String version;

    /**
     * The web container in which the application is running.
     */
    private String webContainer;
    
    /**
     * Time associated with this object.
     */
    private TimeCollection times = new TimeCollection();
    
    /**
     * Configuration properties.
     */
    private Map<String, Property> config =
        new LinkedHashMap<String, Property>();
    
    /**
     * Organizations.
     */
    private List<Organization> organizations = new ArrayList<Organization>();

    /**
     * @return the instanceIdentifier
     */
    public InstanceIdentifier getInstanceIdentifier()
    {
        return instanceIdentifier;
    }

    /**
     * @param instanceIdentifier the instanceIdentifier to set
     */
    public void setInstanceIdentifier(final InstanceIdentifier instanceIdentifier)
    {
        this.instanceIdentifier = instanceIdentifier;
    }

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
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(final String address)
    {
        this.address = address;
    }

    /**
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(final String version)
    {
        this.version = version;
    }

    /**
     * @return the webContainer
     */
    public String getWebContainer()
    {
        return webContainer;
    }

    /**
     * @param webContainer the webContainer to set
     */
    public void setWebContainer(final String webContainer)
    {
        this.webContainer = webContainer;
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
     * @return the config
     */
    public Map<String, Property> getConfig()
    {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(final Map<String, Property> config)
    {
        this.config =
            (config == null) ? new LinkedHashMap<String, Property>() : config;
    }

    /**
     * @return the organizations
     */
    public List<Organization> getOrganizations()
    {
        return organizations;
    }

    /**
     * @param organizations the organizations to set
     */
    public void setOrganizations(final List<Organization> organizations)
    {
        this.organizations =
            (organizations == null) ? new ArrayList<Organization>()
                : organizations;
    }
}
