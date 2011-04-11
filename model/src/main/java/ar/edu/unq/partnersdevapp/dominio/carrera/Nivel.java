package ar.edu.unq.partnersdevapp.dominio.carrera;

/**
 * El nivel esta dividido en bandas. La jerarquia es para poder <strong>ordenar
 * e identificar</strong> una lista de niveles.<br/>
 * Ej: Junior [0,50,100]
 * 
 * @author leo
 */
public class Nivel {

    private String nombre;

    private SubNivel subNivel;

    private int jerarquia;

    public Nivel() {

    }

    public Nivel(final String nombre, final SubNivel bandas, final int jerarquia) {
        // TODO: agregarlo al mapeo con mediador
        this.setSubNivel(bandas);
        this.setJerarquia(jerarquia);
        this.setNombre(nombre);

    }

    @Override
    public String toString() {
        return "(" + this.getJerarquia() + "," + this.getNombre() + ")";
    }

    // **********************
    // ***** Gets & Sets

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public SubNivel getSubNivel() {
        return subNivel;
    }

    public void setSubNivel(final SubNivel subNivel) {
        this.subNivel = subNivel;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(final int jerarquia) {
        this.jerarquia = jerarquia;
    }

}
