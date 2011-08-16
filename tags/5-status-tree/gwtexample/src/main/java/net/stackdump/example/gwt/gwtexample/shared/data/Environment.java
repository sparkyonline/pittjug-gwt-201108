package net.stackdump.example.gwt.gwtexample.shared.data;

/**
 * Status for an entire environment.
 */
public class Environment extends BaseLinkedMap<InstanceIdentifier, Instance>
{
    /**
     * Overloaded put to make adding status easier.
     * 
     * @param host The host.
     * @param instanceName The name of the instance.
     * @param instance The instance data.
     * @return The prior value, or <code>null</code> if none.
     * @see #put(InstanceIdentifier, Instance)
     */
    public Instance put(final String host, final String instanceName,
        final Instance instance)
    {
        final InstanceIdentifier id =
            new InstanceIdentifier(host, instanceName);
        return put(id, instance);
    }
}
