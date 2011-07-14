package ar.edu.unq.partnersdevapp.vista.panel;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;

import ar.edu.unq.partnersdevapp.vista.models.ModelTable;

/**
 * Tabla para mostrar lista de entidades. Necesita modelo de tabla y lista de
 * atributos a mostrar.<br>
 * Debe tener su correspondiente html .Ver "TablePanelTemplatehtml"
 */
public class TablePanel<T> extends Panel {

    private static final long serialVersionUID = 1L;

    private WebMarkupContainer tableContainer;

    private ModelTable<T> modelTable;

    private PropertyListView<T> table;

    public TablePanel(final String entidad, final ModelTable<T> aModelTable, final List<String> attributes) {
        super(entidad + "TablePanel");
        this.setOutputMarkupId(true);
        modelTable = aModelTable;
        this.addTable(entidad, attributes);
    }

    private void addTable(final String entidad, final List<String> attributes) {
        tableContainer = new WebMarkupContainer(entidad + "TableContainer");

        table = new PropertyListView<T>(entidad + "Table", modelTable.getFilas()) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<T> item) {
                for (String string : attributes) {
                    item.add(new Label(string));
                }
            }
        };
        tableContainer.add(table);
        tableContainer.setOutputMarkupId(true);
        this.add(tableContainer);
    }

    /** TODO: problema de referencia de objetos */
    public void update(final List<T> list) {
        table.setModelObject(list);
        // this.getModelTable().setFilas(list);
    }

    public void setTableContainer(final WebMarkupContainer tableContainer) {
        this.tableContainer = tableContainer;
    }

    public WebMarkupContainer getTableContainer() {
        return tableContainer;
    }

    public ModelTable<T> getModelTable() {
        return modelTable;
    }

    public void setModelTable(final ModelTable<T> modelTable) {
        this.modelTable = modelTable;
    }

    public void setTable(final PropertyListView<T> table) {
        this.table = table;
    }

    public PropertyListView<T> getTable() {
        return table;
    }
}
