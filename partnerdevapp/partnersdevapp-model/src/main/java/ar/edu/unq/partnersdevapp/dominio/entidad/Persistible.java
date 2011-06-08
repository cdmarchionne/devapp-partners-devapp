package ar.edu.unq.partnersdevapp.dominio.entidad;


/**
 * Persistible
 */
public interface Persistible {

    int getId();

    void setId(int id);

    Long getVersion();

    void setVersion(Long version);

}
