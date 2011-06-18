package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * Persistible
 */
public interface Persistible {
    @SuppressWarnings("PMD")
    int getId();

    @SuppressWarnings("PMD")
    void setId(int id);

    Long getVersion();

    void setVersion(Long version);

}
