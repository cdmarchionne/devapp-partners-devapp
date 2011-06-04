package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * Entidad
 */
public class Entidad implements Persistible {

    private int id;

    private Long version;

    public Entidad() {
        super();
    }

    public Entidad(final int id, final Long version) {
        this();
        this.id = id;
        this.version = version;
    }

    @Override
    public int getId() {
        return id;
    }

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
