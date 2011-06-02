package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * Entidad
 */
public class Entidad implements Persistible {

    private Integer id;

    private Long version;

    public Entidad() {
        super();
    }

    public Entidad(final Integer id, final Long version) {
        this();
        this.id = id;
        this.version = version;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
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
