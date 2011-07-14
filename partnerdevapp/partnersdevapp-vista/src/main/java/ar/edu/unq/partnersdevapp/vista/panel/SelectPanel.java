package ar.edu.unq.partnersdevapp.vista.panel;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;

import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * FilterPanel + TablePanel.<br>
 * 
 * Asociar Html correspondiente. Ver SelectPanelTemplate
 */
public abstract class SelectPanel<T, S> extends Panel {

    private static final long serialVersionUID = 1L;

    private TablePanel<T> panelTable;

    private FilterPanel<T, S> panelFilter;

    public SelectPanel(final String entidad) {
        super(entidad + "SelectPanel");
        this.addSubPanels(entidad);
    }

    public void addSubPanels(final String entidad) {
        Form<T> form = new Form<T>(entidad + "Form");

        Button button = this.createFilterButton(entidad);
        button.setDefaultFormProcessing(true);

        panelTable = this.createPanelTable();
        panelTable.setOutputMarkupId(true);
        panelFilter = this.createPanelFilter();

        form.add(button);
        form.add(panelFilter);
        form.add(panelTable);

        form.add(new FeedbackPanel("feedback"));

        this.add(form);
    }

    private AjaxButton createFilterButton(final String entidad) {
        AjaxButton button = new AjaxButton(entidad + "FilterButton") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                SelectPanel.this.filtrar();
                target.addComponent(SelectPanel.this.getPanelTable().getTableContainer());
            }
        };
        return button;
    }

    public void filtrar() {
        try {
            panelTable.update(this.getPanelFilter().getFilterData());
        } catch (NoHayResultadoException e) {
            /** TODO : el feedback no lo hereda? */
            this.info(e.getMessage());
            this.error(e.getMessage());
        }
    }

    public abstract FilterPanel<T, S> createPanelFilter();

    public abstract TablePanel<T> createPanelTable();

    public abstract List<String> getAttributes();

    public TablePanel<T> getPanelTable() {
        return panelTable;
    }

    public FilterPanel<T, S> getPanelFilter() {
        return panelFilter;
    }

    public void setPanelTable(final TablePanel<T> panelTable) {
        this.panelTable = panelTable;
    }

    public void setPanelFilter(final FilterPanel<T, S> panelFilter) {
        this.panelFilter = panelFilter;
    }

}
