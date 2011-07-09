package ar.edu.unq.partnersdevapp.vista.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: description
 * 
 * @param <T>
 */
public class ModelTable<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> filas = new ArrayList<T>();

    public List<T> getFilas() {
        return filas;
    }

    public void setFilas(final List<T> filas) {
        this.filas = filas;
    }

}
