package ar.edu.unq.partnersdevapp.vista.models;

import java.io.Serializable;

/**
 * Modelo solo para filtro plan id. TODO: generalizar para id
 */
public class ModelFilterPlanByID implements Serializable {

    private static final long serialVersionUID = 1L;

    String id;

    public ModelFilterPlanByID() {

    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
