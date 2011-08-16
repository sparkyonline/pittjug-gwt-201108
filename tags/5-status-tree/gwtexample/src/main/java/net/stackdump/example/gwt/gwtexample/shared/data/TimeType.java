package net.stackdump.example.gwt.gwtexample.shared.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Values for names of times to display.
 */
public enum TimeType implements IsSerializable
{
    /**
     * The time of creation.
     */
    Creation,
    
    /**
     * The time of the report. 
     */
    Report,
    
    /**
     * Time of last access.
     */
    LastAccess;
}
