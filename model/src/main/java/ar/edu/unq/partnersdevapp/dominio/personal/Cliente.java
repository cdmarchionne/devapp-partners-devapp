package ar.edu.unq.partnersdevapp.dominio.personal;

/**
 * TODO: Modelar Razon Social como otro Objeto
 */
public class Cliente extends Persona {

    private String razonSocial;

    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Cliente(final String razonSocial) {
        super();
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

}
