package ar.edu.unq.partnersdevapp.dominio.carrera;

/**
 * Posicion en un nivel. Cuando se asocia a una "info plan" da la posicion
 * completa.
 * 
 * @author leo
 */
public class Posicion {
    private String nivelNombre;

    private int banda;

    public Posicion() {
        super();
    }

    public Posicion(final String nivel, final int subnivel) {
        this.setNivelNombre(nivel);
        this.setBanda(subnivel);
    }

    public Posicion(final Posicion posicion) {
        this.setNivelNombre(posicion.getNivelNombre());
        this.setBanda(posicion.getBanda());
    }

    @Override
    public String toString() {
        return "(" + this.getNivelNombre() + "," + this.getBanda() + ")";
    }

    @Override
    public boolean equals(final Object posicion) {
        boolean condicionNivel = false;
        boolean condicionSubNivel = false;

        if (posicion != null) {
            condicionNivel = this.getNivelNombre().equals(((Posicion) posicion).getNivelNombre());
            condicionSubNivel = this.getBanda() == ((Posicion) posicion).getBanda();
        }
        return condicionNivel && condicionSubNivel;
    }

    /* TODO : averiguar! */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    // ******************
    // ****** Gets & Sets
    public String getNivelNombre() {
        return nivelNombre;
    }

    public void setNivelNombre(final String nivel) {
        nivelNombre = nivel;
    }

    public int getBanda() {
        return banda;
    }

    public void setBanda(final int subnivel) {
        banda = subnivel;
    }

}
