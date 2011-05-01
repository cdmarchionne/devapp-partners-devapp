package ar.edu.unq.partnersdevapp.dominio.personal;

public class Cliente extends Persona {

    private String razonSocial;

    public Cliente(final String nombre, final String apellido, final String dni, final String razonSocial) {
        super(nombre, apellido, dni);
        this.razonSocial = razonSocial;
    }

    public void setRazonSocial(final String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
}
