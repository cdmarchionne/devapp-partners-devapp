package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashSet;
import java.util.Set;

/**
 * PONER DESCRIPCION
 */
public class Tecnologia {

    private static Set<String> listaTecnologia = new HashSet<String>();

    private String tecnologiaActual;

    public Tecnologia(final String tecnologiaActual) {
        super();
        if (!listaTecnologia.contains(tecnologiaActual)) {
            Tecnologia.addTecnologia(tecnologiaActual);
            // throw NoClassDefFoundException;
        }
        this.tecnologiaActual = tecnologiaActual;
    }

    public static boolean addTecnologia(final String nombre) {
        return listaTecnologia.add(nombre);
    }

    public static boolean removeTecnologia(final String nombre) {
        return listaTecnologia.remove(nombre);
    }

    public static void renameCategoria(final String nombreViejo, final String nombreNuevo) {
        removeTecnologia(nombreViejo);
        addTecnologia(nombreNuevo);
    }

    public static boolean existeTecnologia(final String nombre) {
        return listaTecnologia.contains(nombre);
    }

    public String getTecnologiaActual() {
        return tecnologiaActual;
    }
}