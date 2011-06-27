package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * Persistible
 */
public interface Persistible {

    int getId();// NOPMD

    void setId(int id);// NOPMD

    Long getVersion();

    void setVersion(Long version);

}
