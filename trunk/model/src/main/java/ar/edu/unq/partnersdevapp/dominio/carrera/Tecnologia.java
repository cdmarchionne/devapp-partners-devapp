package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: description
 */
public class Tecnologia {

    private static Set<String> tecnologia = new HashSet<String>();

    public static boolean addTecnologia(final String nombre) {
        return tecnologia.add(nombre);
    }

    public static boolean removeTecnologia(final String nombre) {
        return tecnologia.remove(nombre);
    }

    public static boolean esTecnologia(final String nombre) {
        return tecnologia.contains(nombre);
    }

    public static String getTecnologias() {
        return tecnologia.toString();
    }

    public static void main(final String[] args) {
        Tecnologia.addTecnologia("JAVA");
        Tecnologia.addTecnologia("Poo");

        System.out.println(Tecnologia.getTecnologias());

    }
}