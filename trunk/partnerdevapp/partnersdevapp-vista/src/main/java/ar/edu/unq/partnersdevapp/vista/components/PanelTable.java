package ar.edu.unq.partnersdevapp.vista.components;

import java.util.List;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import ar.edu.unq.partnersdevapp.vista.models.ModelTable;

/**
 * Tabla para mostrar lista de entidades. Necesita modelo de tabla y lista de
 * atributos a mostrar.
 */
public class PanelTable<T> extends WebMarkupContainer {

    private static final long serialVersionUID = 1L;

    PropertyListView<T> table;

    public PanelTable(final ModelTable<T> modelTable, final List<String> attributes) {
        super("containerTable");
        this.setOutputMarkupId(true);
        this.iniciar(modelTable, attributes);
    }

    private void iniciar(final ModelTable<T> modelTable, final List<String> attributes) {
        table = new PropertyListView<T>("table", modelTable.getFilas()) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<T> item) {
                for (String string : attributes) {
                    item.add(new Label(string));
                }
            }
        };
        table.setOutputMarkupId(true);
        this.add(table);
    }

    public void setTable(final PropertyListView<T> table) {
        this.table = table;
    }

    public PropertyListView<T> getTable() {
        return table;
    }
}
