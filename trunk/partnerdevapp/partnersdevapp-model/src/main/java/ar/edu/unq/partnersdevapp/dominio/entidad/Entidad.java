package ar.edu.unq.partnersdevapp.dominio.entidad;

/**
 * TODO: description
 */
public class Entidad implements Persistible {

    private int id;

    // private int version;

    public Entidad() {
    }

    public Entidad(final String id) {
        this();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(final int id) {
        this.id = id;
    }
    //
    // @Override
    // public int getVersion() {
    // return version;
    // }
    //
    // @Override
    // public void setVersion(final int version) {
    // this.version = version;
    // }

}
