package net.stackdump.example.gwt.gwtexample.client.tree;

import java.util.List;

import net.stackdump.example.gwt.gwtexample.shared.data.Session;

/**
 * Container for a session with no emulator children.
 */
public class LeafSessionContainer extends SessionContainer<Session>
{
  public LeafSessionContainer(final List<Session> items)
  {
    super(Session.class, items);
  }
}
