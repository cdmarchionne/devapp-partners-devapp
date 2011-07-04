package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Manejo de Experiencias. Se pueden agregar, borrar, cambiar el nombre de las
 * Niveles de Experiencia existentes. Cuando se crea una Experiencia se le pasa
 * el nombre y el orden de prioridad correspondiente. Se pueden modificar los
 * nivel de experiencia (incrementar o decrementar).
 */
public class Experiencia extends Entidad {

    private static final long serialVersionUID = 1L;

    private static List<String> listaExperiencia = new ArrayList<String>();

    private String experienciaActual;

    public Experiencia(final String experienciaActual) {
        super();
        if (!listaExperiencia.contains(experienciaActual)) {
            Experiencia.addExperiencia(experienciaActual);
            // throw NoClassDefFoundException;
        }
        this.experienciaActual = experienciaActual;
    }

    /** Indice de Prioridad de la Experiencia */
    public static Integer indiceExperiencia(final String nombreExperiencia) {
        return listaExperiencia.indexOf(nombreExperiencia);
    }

    /** Nombre utilizado para representar la Experiencia de Prioridad buscada */
    public static String nombreExperiencia(final Integer indice) {
        return listaExperiencia.get(indice);
    }

    /**
     * Averiguo si una determinada "experiencia" esta cargado en la lista de
     * Experiencias existentes
     */
    public static boolean existeExperiencia(final String nombre) {
        return listaExperiencia.contains(nombre);
    }

    /** Experiencias de Mayor Nivel */
    public static String maxima() {
        return listaExperiencia.get(listaExperiencia.size() - 1);
    }

    /** Experiencias de menor Nivel */
    public static String minima() {
        return listaExperiencia.get(0);
    }

    /** Agregar una Experiencia Nueva */
    public static void addExperiencia(final String nombre) {
        addExperiencia(listaExperiencia.size(), nombre);
    }

    /** Agregar una Experiencia Nueva indicando la Prioridad */
    public static void addExperiencia(final Integer posicion, final String nombre) {
        if (!existeExperiencia(nombre) && validarIndiceAddCat(posicion)) {
            listaExperiencia.add(posicion, nombre);
        }
    }

    /** Eliminar una experiencia */
    public static boolean removeExperiencia(final String nombre) {
        return listaExperiencia.remove(nombre);
    }

    /** Cambiar el nombre de la Experiencia */
    public static void renameExperiencia(final String nombreViejo, final String nombreNuevo) {
        listaExperiencia.set(listaExperiencia.indexOf(nombreViejo), nombreNuevo);
    }

    /** Comprueba el indice de Prioridad cuando agrego una Experiencia Nueva */
    private static boolean validarIndiceAddCat(final Integer indice) {
        return 0 <= indice && indice <= listaExperiencia.size();
    }

    /** Comprueba que el indice de Prioridad buscado sea valido */
    private static boolean validarIndice(final Integer indice) {
        return 0 <= indice && indice < listaExperiencia.size();
    }

    /** Experiencia Actual */
    public String getExperienciaActual() {
        return experienciaActual;
    }

    /** Decrementa el Nivel de Experiencia Actual */
    public void bajarExperiencia() {
        Integer indiceExperiencia = indiceExperiencia(experienciaActual);

        if (validarIndice(indiceExperiencia - 1)) {
            experienciaActual = nombreExperiencia(indiceExperiencia - 1);
        }
    }

    /** Incrementa el Nivel de Experiencia Actual */
    public void subirExperiencia() {
        Integer indiceExperiencia = indiceExperiencia(experienciaActual);

        if (validarIndice(indiceExperiencia + 1)) {
            experienciaActual = nombreExperiencia(indiceExperiencia + 1);
        }
    }

    /**
     * Calculo la diferencia de mi Nivel de Experiencia Actual y el Requisito de
     * Experiencia deseado
     */
    public Integer difenciaNecesidades(final Experiencia requisito) {
        return this.difenciaNecesidades(requisito.getExperienciaActual());
    }

    public Integer difenciaNecesidades(final String requisito) {
        return indiceExperiencia(experienciaActual) - indiceExperiencia(requisito);
    }

    /**
     * Comprueba que mi Nivel de Experiencia Actual cumpla con el Requisito de
     * Experiencia deseado
     */
    public boolean cumbreNecesidades(final Experiencia requisito) {
        return this.cumbreNecesidades(requisito.getExperienciaActual());
    }

    public boolean cumbreNecesidades(final String requisito) {
        return this.difenciaNecesidades(requisito) >= 0;
    }

    public static List<String> getListaExperiencia() {
        return listaExperiencia;
    }

    public static void setListaExperiencia(final List<String> listaExperiencia) {
        Experiencia.listaExperiencia = listaExperiencia;
    }

    public void setExperienciaActual(final String experienciaActual) {
        this.experienciaActual = experienciaActual;
    }

}