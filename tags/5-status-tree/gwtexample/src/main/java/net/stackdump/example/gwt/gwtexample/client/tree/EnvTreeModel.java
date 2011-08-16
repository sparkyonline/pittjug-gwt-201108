package net.stackdump.example.gwt.gwtexample.client.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.stackdump.example.gwt.gwtexample.client.Messages;
import net.stackdump.example.gwt.gwtexample.shared.data.Emulator;
import net.stackdump.example.gwt.gwtexample.shared.data.Environment;
import net.stackdump.example.gwt.gwtexample.shared.data.Instance;
import net.stackdump.example.gwt.gwtexample.shared.data.InstanceIdentifier;
import net.stackdump.example.gwt.gwtexample.shared.data.Organization;
import net.stackdump.example.gwt.gwtexample.shared.data.Session;
import net.stackdump.example.gwt.gwtexample.shared.data.SessionPool;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.TreeViewModel;

/**
 * Tree model to display some brief information about an environment.
 */
public class EnvTreeModel implements TreeViewModel
{
  private final Messages messages = GWT.create(Messages.class);

  /**
   * The environment to display.
   */
  final Environment env;

  /**
   * Constructor.
   * 
   * @param env
   *          The environment status data.
   */
  public EnvTreeModel(final Environment env)
  {
    this.env = env;
  }

  /**
   * Get info about the given object within the tree.
   * 
   * @see TreeViewModel#getNodeInfo(Object)
   */
  @Override
  public <T> NodeInfo<?> getNodeInfo(final T value)
  {
    final NodeInfo<?> result;

    if (value instanceof Environment)
    {
      // An environment will provide a list of instances.

      final Environment env = (Environment) value;
      final ListDataProvider<Instance> provider = new ListDataProvider<Instance>(
          new ArrayList<Instance>(env.values()));

      final Cell<Instance> cell = new AbstractCell<Instance>() {
        @Override
        public void render(final Context context, final Instance value,
            final SafeHtmlBuilder sb)
        {
          final InstanceIdentifier id = value.getInstanceIdentifier();
          sb.appendEscaped(id.getHost());
          sb.appendEscaped(" - ");
          sb.appendEscaped(id.getInstance());
        }
      };

      result = new DefaultNodeInfo<Instance>(provider, cell);
    }
    else if (value instanceof Instance)
    {
      // An instance will provide a list of organizations.

      final Instance instance = (Instance) value;

      final ListDataProvider<Organization> provider = new ListDataProvider<Organization>(
          instance.getOrganizations());
      final Cell<Organization> cell = new AbstractCell<Organization>() {
        @Override
        public void render(final Context context, final Organization value,
            final SafeHtmlBuilder sb)
        {
          sb.appendEscaped(value.getName());
        }
      };

      result = new DefaultNodeInfo<Organization>(provider, cell);
    }
    else if (value instanceof Organization)
    {
      // An organization can potentially provide a list of exclusive
      // sessions, and another list of pooled sessions.

      final Organization org = (Organization) value;

      final List<Session> sessions = org.getSessions();
      final List<SessionPool> pools = org.getSessionPools();

      final ListDataProvider<SessionContainer<?>> provider = new ListDataProvider<SessionContainer<?>>();
      if (!isEmpty(sessions))
      {
        provider.getList().add(new LeafSessionContainer(sessions));
      }
      if (!isEmpty(pools))
      {
        provider.getList().add(new PooledSessionContainer(pools));
      }

      final Cell<SessionContainer<?>> cell = new AbstractCell<SessionContainer<?>>() {
        @Override
        public void render(final Context context,
            final SessionContainer<?> value, final SafeHtmlBuilder sb)
        {
          if (value instanceof LeafSessionContainer)
          {
            sb.appendEscaped(messages.treeExclusiveSessions());
          }
          else if (value instanceof PooledSessionContainer)
          {
            sb.appendEscaped(messages.treePooledSessions());
          }
        }
      };
      result = new DefaultNodeInfo<SessionContainer<?>>(provider, cell);
    }
    else if (value instanceof LeafSessionContainer)
    {
      // This is the list of exclusive sessions, so create the list of them.

      final LeafSessionContainer sessions = (LeafSessionContainer) value;
      final ListDataProvider<Session> provider = new ListDataProvider<Session>(
          sessions.getItems());

      final Cell<Session> cell = createSessionCell();
      result = new DefaultNodeInfo<Session>(provider, cell);
    }
    else if (value instanceof PooledSessionContainer)
    {
      // This is the list of session pools, so create the list of them.

      final PooledSessionContainer pools = (PooledSessionContainer) value;
      final ListDataProvider<SessionPool> provider = new ListDataProvider<SessionPool>(
          pools.getItems());

      final Cell<SessionPool> cell = new AbstractCell<SessionPool>() {
        @Override
        public void render(final Context context, final SessionPool value,
            final SafeHtmlBuilder sb)
        {
          sb.appendEscaped(value.getName());
          sb.appendEscaped(" - ");
          sb.appendEscaped(value.getID());
        }
      };

      result = new DefaultNodeInfo<SessionPool>(provider, cell);
    }
    else if (value instanceof SessionPool)
    {
      // This is a particular session pool that contains sessions.

      final SessionPool pool = (SessionPool) value;
      final ListDataProvider<Session> provider = new ListDataProvider<Session>(
          pool.getSessions());

      final Cell<Session> cell = createSessionCell();
      result = new DefaultNodeInfo<Session>(provider, cell);
    }
    else if (value instanceof Session)
    {
      // This is a session that contains emulators.

      final Session session = (Session) value;
      final ListDataProvider<Emulator> provider = new ListDataProvider<Emulator>(
          session.getEmulators());

      final Cell<Emulator> cell = new AbstractCell<Emulator>() {
        @Override
        public void render(final Context context, final Emulator value,
            final SafeHtmlBuilder sb)
        {
          sb.appendEscaped(value.getSystem());
          sb.appendEscaped(" - ");
          sb.appendEscaped(value.getCurrentScreen());
        }
      };

      result = new DefaultNodeInfo<Emulator>(provider, cell);
    }
    else
    {
      result = null;
    }

    return result;
  }

  /**
   * Regardless of pooled or exclusive, create a cell to render session info.
   * 
   * @return The cell.
   */
  private Cell<Session> createSessionCell()
  {
    return new AbstractCell<Session>() {
      @Override
      public void render(final Context context, final Session value,
          final SafeHtmlBuilder sb)
      {
        sb.appendEscaped(value.getName());
        sb.appendEscaped(" (");
        sb.appendEscaped(value.getType().name());
        sb.appendEscaped(") - ");
        sb.appendEscaped(value.getID());
      }
    };
  }

  /**
   * Determine of the given object within the tree represents a leaf node.
   * 
   * @see TreeViewModel#isLeaf(Object)
   */
  @Override
  public boolean isLeaf(final Object value)
  {
    boolean result = false;

    if (value == null)
    {
      result = true;
    }
    else if (value instanceof Emulator)
    {
      // Emulators are always leaves.
      result = true;
    }
    else if (value instanceof Session)
    {
      // Sessions are leaves if they have no emulators.
      final Session session = (Session) value;
      result = isEmpty(session.getEmulators());
    }
    else if (value instanceof SessionContainer<?>)
    {
      // Any session container is a leaf if it contains no sessions.
      final SessionContainer<?> container = (SessionContainer<?>) value;
      result = isEmpty(container.getItems());
    }
    else if (value instanceof Organization)
    {
      // An organization is a leaf if it contains neither exclusive sessions or
      // pools.
      final Organization org = (Organization) value;
      result = isEmpty(org.getSessions()) && isEmpty(org.getSessionPools());
    }

    return result;
  }

  /**
   * Helper method to determine if a collection is empty, without pulling in a
   * whole different library.
   * 
   * @param collection
   *          The collection to evaluate.
   * @return <code>true</code> if empty, <code>false</code> otherwise.
   */
  private static boolean isEmpty(final Collection<?> collection)
  {
    return collection == null || collection.isEmpty();
  }
}
