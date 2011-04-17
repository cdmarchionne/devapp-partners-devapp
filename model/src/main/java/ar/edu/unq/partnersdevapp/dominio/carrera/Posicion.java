package ar.edu.unq.partnersdevapp.dominio.carrera;

/**
 * Posicion en una carrera.
 */
public class Posicion {
    private String nivelNombre;

    private int subnivel;

    public Posicion() {
        super();
    }

    public Posicion(final String nivel, final int subnivel) {
        this.setNivelNombre(nivel);
        this.setSubnivel(subnivel);
    }

    public Posicion(final Posicion posicion) {
        this.setNivelNombre(posicion.getNiveNombrel());
        this.setSubnivel(posicion.getSubnivel());
    }

    @Override
    public String toString() {
        return "(" + this.getNiveNombrel() + "," + this.getSubnivel() + ")";
    }

    @Override
    public boolean equals(final Object posicion) {
        boolean condicionNivel = false;
        boolean condicionSubNivel = false;

        if (posicion != null) {
            condicionNivel = this.getNiveNombrel().equals(((Posicion) posicion).getNiveNombrel());
            condicionSubNivel = this.getSubnivel() == ((Posicion) posicion).getSubnivel();
        }
        return condicionNivel && condicionSubNivel;
    }

    /* TODO : averiguar! */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    public String getNiveNombrel() {
        return nivelNombre;
    }

    public void setNivelNombre(final String nivel) {
        nivelNombre = nivel;
    }

    public int getSubnivel() {
        return subnivel;
    }

    public void setSubnivel(final int subnivel) {
        this.subnivel = subnivel;
    }

}
