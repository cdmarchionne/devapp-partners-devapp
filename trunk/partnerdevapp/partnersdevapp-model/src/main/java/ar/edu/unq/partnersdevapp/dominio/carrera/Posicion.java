package ar.edu.unq.partnersdevapp.dominio.carrera;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Posicion en un nivel. Cuando se asocia a una "info plan" da la posicion
 * completa.
 * 
 * @author leo
 */
public class Posicion extends Entidad {

    private static final long serialVersionUID = 1L;

    private Nivel nivel;

    private int numeroDeBanda;

    public Posicion() {
        super();
    }

    public Posicion(final Nivel nivel, final int subnivel) {
        this.setNivel(nivel);
        this.setNumeroDeBanda(subnivel);
    }

    public Posicion(final Posicion posicion) {
        this.setNivel(posicion.getNivel());
        this.setNumeroDeBanda(posicion.getNumeroDeBanda());
    }

    @Override
    public String toString() {
        return "(" + this.getNivel() + "," + this.getNumeroDeBanda() + ")";
    }

    public boolean isIgual(final Posicion aPosicion) {
        boolean condicionNivel = false;
        boolean condicionSubNivel = false;

        if (aPosicion != null) {
            condicionNivel = this.getNivel().equals(aPosicion.getNivel());
            condicionSubNivel = this.getNumeroDeBanda() == aPosicion.getNumeroDeBanda();
        }
        return condicionNivel && condicionSubNivel;
    }

    // ******************
    // ****** Gets & Sets

    public int getNumeroDeBanda() {
        return numeroDeBanda;
    }

    public void setNumeroDeBanda(final int subnivel) {
        numeroDeBanda = subnivel;
    }

    public void setNivel(final Nivel nivel) {
        this.nivel = nivel;
    }

    public Nivel getNivel() {
        return nivel;
    }
}
