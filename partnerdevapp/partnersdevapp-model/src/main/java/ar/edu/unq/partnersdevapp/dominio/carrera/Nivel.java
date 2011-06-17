package ar.edu.unq.partnersdevapp.dominio.carrera;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * El nivel esta dividido en bandas. La jerarquia es para poder <strong>ordenar
 * e identificar</strong> una lista de niveles.<br/>
 * Es decir que existe un ti Ej: Junior [0,50,100] Además contiene datos para el
 * calculo de sueldos
 * 
 * @author leo
 */
public class Nivel extends Entidad {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private Banda banda;

    private int sueldoMaximo = 0;

    private int sueldoMinimo = 0;

    /**
     * Nota: la jerarquia se autosetea al ingresar el nivel al plan de carrera.
     * 
     */
    public Nivel(final String nombre, final Banda bandas, final int maximo, final int minimo) {
        super();
        this.setBanda(bandas);
        this.setNombre(nombre);
        this.setSueldoMaximo(maximo);
        this.setSueldoMinimo(minimo);
    }

    @Override
    public boolean equals(final Object obj) {
        return this.getNombre().equals(((Nivel) obj).getNombre());
    }

    @Override
    public String toString() {
        return "(" + this.getNombre() + ")";
    }

    // **********************
    // ***** Gets & Sets

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(final Banda subNivel) {
        banda = subNivel;
    }

    public int getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(final int sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    public int getSueldoMinimo() {
        return sueldoMinimo;
    }

    public void setSueldoMinimo(final int sueldoMinimo) {
        this.sueldoMinimo = sueldoMinimo;
    }

}
