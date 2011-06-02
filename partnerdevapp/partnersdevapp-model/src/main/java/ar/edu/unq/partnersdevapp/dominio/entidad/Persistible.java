package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * Persistible
 */
public interface Persistible {

    Integer getId();

    void setId(Integer id);

    Long getVersion();

    void setVersion(Long version);

}
