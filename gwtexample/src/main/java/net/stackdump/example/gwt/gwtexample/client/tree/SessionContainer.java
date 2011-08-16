package net.stackdump.example.gwt.gwtexample.client.tree;

import java.util.List;

/**
 * Base class for exclusive and pooled sessions that live under organizations.
 */
public class SessionContainer<T>
{
  private final Class<?> type;
  private final List<T> items;

  /**
   * Constructor.
   * 
   * @param type
   *          Type of the contained items.
   * @param items
   *          The items themselves.
   */
  SessionContainer(final Class<?> type, final List<T> items)
  {
    this.type = type;
    this.items = items;
  }

  public Class<?> getType()
  {
    return type;
  }

  public List<T> getItems()
  {
    return items;
  }
}
