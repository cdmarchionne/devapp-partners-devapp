package ar.edu.unq.partnersdevapp.vista.panel;

import java.util.List;

import org.apache.wicket.markup.html.panel.Panel;

import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * Panel para ingresar consultas. Debe tener su Html
 * 
 */
public abstract class FilterPanel<T, S> extends Panel {

    private static final long serialVersionUID = 1L;

    private S service;

    private T model;

    /**
     * 
     * @param aModelTable
     * @param componentList
     *            Componentes que se suscriben para ser avisados con un cambio
     */
    public FilterPanel(final String entidad, final T aModel, final S aService) {
        super(entidad + "FilterPanel");
        service = aService;
        model = aModel;
        this.addInputs();
    }

    /**
     * Le pide al servicio los datos con la consulta apropiada. Se debe agregar
     * un modelo para los inputs.
     * 
     * @throws NoHayResultadoException
     */
    public abstract List<T> getFilterData() throws NoHayResultadoException;

    /** Componentes necesarios para el criterio de busqueda */
    public abstract void addInputs();

    // -----------------------
    // -----Gets & Sets ------

    public void setService(final S service) {
        this.service = service;
    }

    public S getService() {
        return service;
    }

    public void setModel(final T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }
}
