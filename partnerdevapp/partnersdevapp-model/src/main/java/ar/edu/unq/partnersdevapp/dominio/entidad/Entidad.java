package ar.edu.unq.partnersdevapp.dominio.entidad;

import java.io.Serializable;

/**
 * Entidad
 */
public class Entidad implements Persistible, Serializable {

    private static final long serialVersionUID = 1L;

    private int id;// NOPMD

    private Long version;

    public Entidad() {
        super();
    }

    public Entidad(final int id, final Long version) {// NOPMD
        this();
        this.id = id;
        this.version = version;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(final int id) {// NOPMD
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
