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

    public PlanDeCarrera(final String especialidad, final String descripcion) {
        this.setEspecialidad(especialidad);
        this.setDescripcion(descripcion);
    }

    /**
     * Agrega el nivel una jerarquia superior a la de nivelLugar desplazando una
     * jerarquia a sus superiores.
     * 
     * TODO : refactor codigo duplicado. Casi .nombre de la carrera se repite
     */
    public void addNivelPosterior(final Nivel nivelNuevo, final String nivelLugar) {
        this.addNivel(nivelNuevo, nivelLugar, 1);
    }

    /**
     * Agrega el nivel con una jerarquia inferior a la de nivelLugar desplazando
     * una jerarquia a sus superiores.
     */
    public void addNivelAnterior(final Nivel nivelNuevo, final String nivelLugar) {
        this.addNivel(nivelNuevo, nivelLugar, 0);
    }

    private void addNivel(final Nivel nivelNuevo, final String nivelLugar, final int anteriorPosterior) {
        if (this.getNiveles().isEmpty()) {
            nivelNuevo.setJerarquia(0);
        } else {
            nivelNuevo.setJerarquia(this.getNivel(nivelLugar).getJerarquia() + anteriorPosterior);
        }
        List<Nivel> nivelesDisponibles = this.getNiveles();
        // if nivelesDisponibles not null
        for (Nivel nivel : nivelesDisponibles) {
            if (nivel.getJerarquia() >= nivelNuevo.getJerarquia()) {
                nivel.subirJerarquiaUnPunto();
            }
        }
        this.getNiveles().add(nivelNuevo);
    }

    /** Devuelve una posicion de nivel superior */
    public Posicion getNivelSuperior(final Posicion posicion) {
        Posicion nuevaPosicion = new Posicion(posicion);

        Nivel nivel = this.getNivel(posicion.getNivelNombre());
        int nuevaBanda = nivel.getBanda().getSubNivelSuperior(posicion.getBanda());

        if (nuevaBanda == -1) {
            // TODO : caso del que sea el ultimo nivel
            nivel = this.getNivel(nivel.getJerarquia() + 1);
            nuevaPosicion.setNivelNombre(nivel.getNombre());
            nuevaPosicion.setBanda(0);
        } else {
            nuevaPosicion.setBanda(nuevaBanda);

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

    /** Calcula en sueldo segun el nivel pasado por parametro */
    public float getSueldo(final Posicion posicionActual) {
        Nivel nivelActual = this.getNivel(posicionActual.getNivelNombre());
        int max = nivelActual.getSueldoMaximo();
        int min = nivelActual.getSueldoMinimo();
        float banda = posicionActual.getBanda();
        return min + banda * (max - min);
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

    public void setNiveles(final List<Nivel> niveles) {
        this.niveles = niveles;
    }

}
