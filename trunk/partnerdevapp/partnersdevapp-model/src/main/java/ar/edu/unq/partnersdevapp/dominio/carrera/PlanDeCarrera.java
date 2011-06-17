package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * 
 * Modela la idea de niveles en una especialidad.
 * 
 * @author leo
 */
public class PlanDeCarrera extends Entidad {

    private static final long serialVersionUID = 1L;

    private String especialidad;

    private String descripcion;

    private List<Nivel> niveles = new ArrayList<Nivel>();

    public PlanDeCarrera(final String especialidad, final String descripcion) {
        super();
        this.setEspecialidad(especialidad);
        this.setDescripcion(descripcion);
    }

    /**
     * Agrega el nivel una jerarquia superior a la de nivelLugar desplazando una
     * jerarquia a sus superiores.
     * 
     * @throws NoHayResultadoException
     */
    public void addNivelPosterior(final Nivel nivelNuevo, final Nivel nivelExistente) throws NoHayResultadoException {
        this.addNivel(nivelNuevo, nivelExistente, 1);
    }

    /**
     * Agrega el nivel con una jerarquia inferior a la de nivelLugar desplazando
     * una jerarquia a sus superiores.
     * 
     * @throws NoHayResultadoException
     */
    public void addNivelAnterior(final Nivel nivelNuevo, final Nivel nivelExistente) throws NoHayResultadoException {
        this.addNivel(nivelNuevo, nivelExistente, 0);
    }

    private void addNivel(final Nivel nivelNuevo, final Nivel nivelExistente, final int anteriorPosterior)
            throws NoHayResultadoException {
        try {
            if (this.getNiveles().isEmpty()) {
                this.getNiveles().add(nivelNuevo);
            } else {
                int lugarJerarquico = this.getJerarquiaDeNivel(nivelExistente) + anteriorPosterior;
                this.getNiveles().add(lugarJerarquico, nivelNuevo);
            }

        } catch (Exception e) {
            throw new NoHayResultadoException();
        }

    }

    /**
     * Devuelve una posicion superior
     * 
     * @throws NoHayResultadoException
     * 
     */
    public Posicion getPosicionSuperior(final Posicion posicion) {
        Posicion nuevaPosicion = new Posicion(posicion);

        int lugarJerarquico = this.getJerarquiaDeNivel(posicion.getNivel());
        Nivel nivelActual = this.getNiveles().get(lugarJerarquico);

        int nuevaBanda = nivelActual.getBanda().getSubNivelSuperior(posicion.getNumeroDeBanda());

        if (nuevaBanda == -1) {
            try {
                nuevaPosicion.setNivel(this.getNivelEnJerarquia(lugarJerarquico + 1));
                nuevaPosicion.setNumeroDeBanda(0);
            } catch (NoHayResultadoException e) {
                nuevaPosicion.setNumeroDeBanda(100);
            }

        } else {
            nuevaPosicion.setNumeroDeBanda(nuevaBanda);

        }
        return nuevaPosicion;
    }

    /**
     * Calcula en sueldo segun el nivel pasado por parametro
     * 
     * @throws NoHayResultadoException
     */
    public float getSueldo(final Posicion posicionActual) throws NoHayResultadoException {
        Nivel nivelActual = posicionActual.getNivel();
        int max = nivelActual.getSueldoMaximo();
        int min = nivelActual.getSueldoMinimo();
        float banda = posicionActual.getNumeroDeBanda();
        return min + banda / 100 * (max - min);
    }

    @Override
    public String toString() {
        return "{" + this.getEspecialidad() + "-" + this.getNiveles() + "}";
    }

    /** Devuelve la jerarquia de un nivel en el plan actual */
    public int getJerarquiaDeNivel(final Nivel nivel) {
        return this.getNiveles().indexOf(nivel);
    }

    public Nivel getNivelEnJerarquia(final int index) throws NoHayResultadoException {
        try {
            return this.getNiveles().get(index);
        } catch (Exception e) {
            throw new NoHayResultadoException();
        }

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

    public void setNiveles(final List<Nivel> niveles) {
        this.niveles = niveles;
    }

    public List<Nivel> getNiveles() {
        return niveles;
    }

}
