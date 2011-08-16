package net.stackdump.example.gwt.gwtexample.client.tree;

import java.util.List;

import net.stackdump.example.gwt.gwtexample.shared.data.SessionPool;

public class PooledSessionContainer extends SessionContainer<SessionPool>
{
  public PooledSessionContainer(final List<SessionPool> items)
  {
    super(SessionPool.class, items);
  }
}
