package ar.edu.unq.partnersdevapp.dominio.personal;

public class Cliente extends Persona {

    private String razonSocial;

    public Cliente(final String razonSocial) {
        super();
        this.razonSocial = razonSocial;
    }

    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
}
