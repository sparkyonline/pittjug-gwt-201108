package net.stackdump.example.gwt.gwtexample.client.tree;

import net.stackdump.example.gwt.gwtexample.shared.data.Environment;

import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Widget that allows replacing with a new tree, when the environment
 * information is updated.
 */
public class EmulatorTree extends Composite
{
  /**
   * Panel housing the tree.
   */
  private SimplePanel panel;

  /**
   * Constructor.
   */
  public EmulatorTree()
  {
    panel = new SimplePanel();
    initWidget(panel);
  }

  /**
   * Update the tree with new environment information.
   * 
   * @param env
   *          The environment status data to display.
   */
  public void updateTree(final Environment env)
  {
    final CellTree mainTree = new CellTree(new EnvTreeModel(env), env);
    panel.setWidget(mainTree);
  }
  
  /**
   * Clear the tree.
   */
  public void clear()
  {
    panel.remove(panel.getWidget());
  }
}
