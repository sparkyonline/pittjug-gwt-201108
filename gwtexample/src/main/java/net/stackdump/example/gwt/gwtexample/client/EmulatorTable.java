package net.stackdump.example.gwt.gwtexample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Table to display emulator status information.
 */
public class EmulatorTable extends Composite
{

  private final Messages messages = GWT.create(Messages.class);
  private CellTable<EmulatorRecord> table;

  /**
   * Constructor.
   * 
   * @param emuList The provider of the list to display.  Note that this current
   * code assumes the wrapped list will remain the same instance throughout the
   * lifecycle.
   */
  public EmulatorTable(final ListDataProvider<EmulatorRecord> emuList)
  {

    table = new CellTable<EmulatorRecord>();
    initWidget(table);
    
    // Set up the table, binding it to the list and preparing for sorting.
    table.setEmptyTableWidget(new Label(messages.tableNoRecords()));
    emuList.addDataDisplay(table);
    ListHandler<EmulatorRecord> sortHandler = new ListHandler<EmulatorRecord>(
        emuList.getList());
    table.addColumnSortHandler(sortHandler);

    // Create the table columns.
    
    TextColumn<EmulatorRecord> hostColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getHost();
      }
    };
    hostColumn.setSortable(true);
    table.addColumn(hostColumn, messages.tableColumnHost());
    sortHandler.setComparator(hostColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(hostColumn));

    TextColumn<EmulatorRecord> instanceColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getInstanceName();
      }
    };
    instanceColumn.setSortable(true);
    table.addColumn(instanceColumn, messages.tableColumnInstance());
    sortHandler.setComparator(instanceColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(instanceColumn));

    TextColumn<EmulatorRecord> orgColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getOrgName();
      }
    };
    orgColumn.setSortable(true);
    table.addColumn(orgColumn, messages.tableColumnOrganization());
    sortHandler.setComparator(orgColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(orgColumn));

    TextColumn<EmulatorRecord> sessionNameColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getSessionName();
      }
    };
    sessionNameColumn.setSortable(true);
    table.addColumn(sessionNameColumn, messages.tableColumnSession());
    sortHandler.setComparator(sessionNameColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(sessionNameColumn));

    TextColumn<EmulatorRecord> sessionTypeColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getSessionType().name();
      }
    };
    sessionTypeColumn.setSortable(true);
    table.addColumn(sessionTypeColumn, messages.tableColumnSessionType());
    sortHandler.setComparator(sessionTypeColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(sessionTypeColumn));

    TextColumn<EmulatorRecord> emuSystemColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getEmuSystem();
      }
    };
    emuSystemColumn.setSortable(true);
    table.addColumn(emuSystemColumn, messages.tableColumnSystem());
    sortHandler.setComparator(emuSystemColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(emuSystemColumn));

    TextColumn<EmulatorRecord> emuCurrentScreenColumn = new TextColumn<EmulatorRecord>() {
      @Override
      public String getValue(EmulatorRecord object)
      {
        return object.getEmuCurrentScreen();
      }
    };
    emuCurrentScreenColumn.setSortable(true);
    table.addColumn(emuCurrentScreenColumn, messages.tableColumnCurrentScreen());
    sortHandler.setComparator(emuCurrentScreenColumn,
        new CaseInsensitiveComparator<EmulatorRecord>(emuCurrentScreenColumn));

  }

  public CellTable<EmulatorRecord> getTable()
  {
    return table;
  }
}
