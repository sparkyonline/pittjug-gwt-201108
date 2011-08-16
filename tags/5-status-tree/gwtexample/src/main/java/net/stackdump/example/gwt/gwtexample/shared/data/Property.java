package net.stackdump.example.gwt.gwtexample.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * A specific config property value.
 */
public class Property implements IsSerializable
{
    /**
     * Is the property dynamic?
     */
    private boolean dynamic;

    /**
     * The property's name.
     */
    private String name;

    /**
     * Is the property configurable?
     */
    private boolean configurable;

    /**
     * The property's current value.
     */
    private String value;

    /**
     * @return the dynamic
     */
    public boolean isDynamic()
    {
        return dynamic;
    }

    /**
     * @param dynamic the dynamic to set
     */
    public void setDynamic(final boolean dynamic)
    {
        this.dynamic = dynamic;
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
     * @return the configurable
     */
    public boolean isConfigurable()
    {
        return configurable;
    }

    /**
     * @param configurable the configurable to set
     */
    public void setConfigurable(final boolean configurable)
    {
        this.configurable = configurable;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(final String value)
    {
        this.value = value;
    }
}
