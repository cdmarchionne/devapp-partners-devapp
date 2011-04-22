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

    public boolean isIgual(final Posicion aPosicion) {
        boolean condicionNivel = false;
        boolean condicionSubNivel = false;

        if (aPosicion != null) {
            condicionNivel = this.getNivelNombre().equals(aPosicion.getNivelNombre());
            condicionSubNivel = this.getBanda() == aPosicion.getBanda();
        }
        return condicionNivel && condicionSubNivel;
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
