package ar.edu.unq.partnersdevapp.vista.components;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;

import ar.edu.unq.partnersdevapp.vista.models.ModelTable;

/**
 * Panel para ingresar consultas.
 * 
 * @param <T>
 * @param <S>
 */
public abstract class PanelFilter<T, S> extends WebMarkupContainer {

    private static final long serialVersionUID = 1L;

    private ModelTable<T> modelTable;

    private S service;

    /**
     * 
     * @param aModelTable
     * @param componentList
     *            Componentes que se suscriben para ser avisados con un cambio
     */
    public PanelFilter(final ModelTable<T> aModelTable, final List<Component> componentList) {
        super("filterPanel");
        this.setModels();
        this.setModelTable(aModelTable);
        this.addInputs();
        this.addFilterButton(componentList);
    }

    /**
     * Le pide al servicio los datos con la consulta apropiada. Se debe agregar
     * un modelo para los inputs.
     */
    public abstract List<T> getNewData();

    /** Obliga a setear los modelos para no tener problemas de null */
    public abstract void setModels();

    /** Componentes necesarios para el criterio de busqueda */
    public abstract void addInputs();

    /** Se ejecuta el filtrado. Avisa a los componentes. */
    protected void addFilterButton(final List<Component> componentList) {
        this.add(new AjaxButton("filterButton") {
            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                PanelFilter.this.filtrar();
                for (Component element : componentList) {
                    target.addComponent(element);
                }

            }
        });
    }

    /** Actualiza los datos en el modelo de la tabla que los muestra */
    public void filtrar() {
        this.getModelTable().setFilas(this.getNewData());
    }

    // -----------------------
    // -----Gets & Sets ------

    public void setService(final S service) {
        this.service = service;
    }

    public ModelTable<T> getModelTable() {
        return modelTable;
    }

    public void setModelTable(final ModelTable<T> modelTable) {
        this.modelTable = modelTable;
    }

    public S getService() {
        return service;
    }
}
