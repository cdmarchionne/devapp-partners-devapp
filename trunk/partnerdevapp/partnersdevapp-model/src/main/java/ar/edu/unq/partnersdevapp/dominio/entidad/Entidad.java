package ar.edu.unq.partnersdevapp.dominio.entidad;

import java.io.Serializable;

/**
 * Entidad
 */
public class Entidad implements Persistible, Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("PMD")
    private int id;

    private Long version;

    public Entidad() {
        super();
    }

    @SuppressWarnings("PMD")
    public Entidad(final int id, final Long version) {
        this();
        this.id = id;
        this.version = version;
    }

    @Override
    public int getId() {
        return id;
    }

    @SuppressWarnings("PMD")
    @Override
    public void setId(final int id) {
        this.id = id;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public void setVersion(final Long version) {
        this.version = version;
    }

}
