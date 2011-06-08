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
    public void addNivelPosterior(final Nivel nivelNuevo, final String nivelLugar) throws NoHayResultadoException {
        this.addNivel(nivelNuevo, nivelLugar, 1);
    }

    /**
     * Agrega el nivel con una jerarquia inferior a la de nivelLugar desplazando
     * una jerarquia a sus superiores.
     * 
     * @throws NoHayResultadoException
     */
    public void addNivelAnterior(final Nivel nivelNuevo, final String nivelLugar) throws NoHayResultadoException {
        this.addNivel(nivelNuevo, nivelLugar, 0);
    }

    private void addNivel(final Nivel nivelNuevo, final String nivelLugar, final int anteriorPosterior)
            throws NoHayResultadoException {
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

    /**
     * Devuelve una posicion superior
     * 
     */
    public Posicion getPosicionSuperior(final Posicion posicion) throws NoHayResultadoException {
        Posicion nuevaPosicion = new Posicion(posicion);

        Nivel nivel = this.getNivel(posicion.getNivelNombre());
        int nuevaBanda = nivel.getBanda().getSubNivelSuperior(posicion.getBanda());

        if (nuevaBanda == -1) {
            nivel = this.getNivel(nivel.getJerarquia() + 1);
            nuevaPosicion.setNivelNombre(nivel.getNombre());
            nuevaPosicion.setBanda(0);
        } else {
            nuevaPosicion.setBanda(nuevaBanda);

        }
        return nuevaPosicion;
    }

    /**
     * Devuelve el nivel de la lista de niveles. Busca por nombre
     * 
     * @throws NoHayResultadoException
     */
    public Nivel getNivel(final String nombre) throws NoHayResultadoException {
        for (Nivel nivel : this.getNiveles()) {
            if (nivel.getNombre().equals(nombre)) { return nivel; }
        }
        throw new NoHayResultadoException();
    }

    /**
     * Devuelve el nivel de la lista de niveles. Busca por jerarquia
     * 
     * @throws NoHayResultadoException
     */
    public Nivel getNivel(final int jerarquia) throws NoHayResultadoException {
        for (Nivel nivel : this.getNiveles()) {
            if (nivel.getJerarquia() == jerarquia) { return nivel; }
        }
        throw new NoHayResultadoException();
    }

    /**
     * Calcula en sueldo segun el nivel pasado por parametro
     * 
     * @throws NoHayResultadoException
     */
    public float getSueldo(final Posicion posicionActual) throws NoHayResultadoException {
        Nivel nivelActual = this.getNivel(posicionActual.getNivelNombre());
        int max = nivelActual.getSueldoMaximo();
        int min = nivelActual.getSueldoMinimo();
        float banda = posicionActual.getBanda();
        return min + banda / 100 * (max - min);
    }

    @Override
    public String toString() {
        return "{" + this.getEspecialidad() + "-" + this.getNiveles() + "}";
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
