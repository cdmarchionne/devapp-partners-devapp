package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Modela la idea de niveles en una especialidad.
 * 
 * @author leo
 */
public class PlanDeCarrera {

    private String especialidad;

    private String descripcion;

    private List<Nivel> niveles = new ArrayList<Nivel>();

    public PlanDeCarrera() {

    }

    public PlanDeCarrera(final String especialidad, final String descripcion) {
        this.setEspecialidad(especialidad);
        this.setDescripcion(descripcion);
    }

    /**
     * Agrega un nivel al plan de carrera.<br/>
     * Obs: Se lo agrega solo al plan de carrera actual.
     */
    public void addNivel(final Nivel nivel) {
        this.getNiveles().add(nivel);
    }

    /** Devuelve una posicion de nivel superior */
    public Posicion getNivelSuperior(final Posicion posicion) {
        Posicion nuevaPosicion = new Posicion(posicion);

        Nivel nivel = this.getNivel(posicion.getNiveNombrel());
        int subNivelNuevo = nivel.getSubNivel().getSubNivelSuperior(posicion.getSubnivel());

        if (subNivelNuevo == -1) {
            // TODO : caso del que sea el ultimo nivel
            nivel = this.getNivel(nivel.getJerarquia() + 1);
            nuevaPosicion.setNivelNombre(nivel.getNombre());
            nuevaPosicion.setSubnivel(0);
        } else {
            nuevaPosicion.setSubnivel(subNivelNuevo);

        }
        return nuevaPosicion;
    }

    /** Devuelve el nivel de la lista de niveles. Busca por nombre */
    public Nivel getNivel(final String nombre) {
        Nivel res = null;
        for (Nivel nivel : this.getNiveles()) {
            if (nivel.getNombre().equals(nombre)) {
                res = nivel;
            }
        }
        return res;
    }

    /** Devuelve el nivel de la lista de niveles. Busca por jerarquia */
    public Nivel getNivel(final int jerarquia) {
        Nivel res = null;
        for (Nivel nivel : this.getNiveles()) {
            if (nivel.getJerarquia() == jerarquia) {
                res = nivel;
            }
        }
        return res;
    }

    // **************************
    // ******* Gets & Sets
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(final String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Nivel> getNiveles() {
        return niveles;
    }

    private void setNiveles(final List<Nivel> niveles) {
        this.niveles = niveles;
    }

}
