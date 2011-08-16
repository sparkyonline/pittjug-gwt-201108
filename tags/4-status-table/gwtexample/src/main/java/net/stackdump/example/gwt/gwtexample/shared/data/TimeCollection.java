package net.stackdump.example.gwt.gwtexample.shared.data;

import java.util.Date;

/**
 * A collection of named times.
 */
public class TimeCollection extends BaseLinkedMap<TimeType, Date>
{
    /**
     * Additional overload for storing long values directly.
     * 
     * @param name The name of the time to store.
     * @param date The time to store.
     * @return The previous value, or <code>null</code> if none.
     * @see #put(String, Date)
     */
    public Long put(final TimeType type, final Long date)
    {
        final Date result = put(type, new Date(date));
        return (result == null) ? null : result.getTime();
    }
}
