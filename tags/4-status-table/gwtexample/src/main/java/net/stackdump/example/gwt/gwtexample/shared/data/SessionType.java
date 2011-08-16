package net.stackdump.example.gwt.gwtexample.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Possible session types.
 */
public enum SessionType implements IsSerializable
{
    /**
     * An exclusive session.
     */
    Exclusive,
    
    /**
     * A pooled session.
     */
    Pooled;
}
