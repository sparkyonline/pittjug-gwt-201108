package net.stackdump.example.gwt.gwtexample.client;

import java.util.Comparator;

import com.google.gwt.user.cellview.client.Column;

/**
 * Column-based, case-insensitive, comparator.
 * 
 * @param <T> Type to compare.
 */
public class CaseInsensitiveComparator<T> implements Comparator<T>
{
    /**
     * The column for obtaining values.
     */
    private final Column<T, String> column;
    
    /**
     * Constructor.
     * 
     * @param column Column for extracting values to compare.
     */
    public CaseInsensitiveComparator(final Column<T, String> column)
    {
        this.column = column;
    }
    
    public int compare(T o1, T o2)
    {
        final boolean o1null = (o1 == null);
        final boolean o2null = (o2 == null);
        
        if (o1null)
        {
            return o2null ? 0 : -1;
        }
        else if (o2null)
        {
            return 1;
        }
        else
        {
          // Use the column to obtain the values, and then compare them.
          return String.CASE_INSENSITIVE_ORDER.compare(column.getValue(o1),
              column.getValue(o2));
        }
    }
}
