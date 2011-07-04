package ar.edu.unq.partnersdevapp.vista.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo para el combo wicket
 */
public class ModelCombo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> opciones = new ArrayList<T>();

    private T seleccion;

    public void setSeleccion(final T seleccion) {
        this.seleccion = seleccion;
    }

    public T getSeleccion() {
        return seleccion;
    }

    public void setOpciones(final List<T> opciones) {
        this.opciones = opciones;
    }

    public List<T> getOpciones() {
        return opciones;
    }
}
