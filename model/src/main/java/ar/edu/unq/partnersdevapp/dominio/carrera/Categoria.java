package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: description
 */
public class Categoria {

    private static List<String> listaCategoria = new ArrayList<String>();

    public static String nombreCategoria(final Integer indice) {
        return listaCategoria.get(indice);
    }

    public static Integer indiceCategoria(final String nombreCategoria) {
        return listaCategoria.indexOf(nombreCategoria);
    }

    public static void addCategoria(final String nombre) {
        addCategoria(listaCategoria.size(), nombre);
    }

    public static void addCategoria(final Integer posicion, final String nombre) {
        if (!listaCategoria.contains(nombre) && 0 <= posicion && posicion <= listaCategoria.size()) {
            listaCategoria.add(posicion, nombre);
        }
    }

    public static boolean removeCategoria(final String nombre) {
        return listaCategoria.remove(nombre);
    }

    public static void renameCategoria(final String nombreViejo, final String nombreNuevo) {
        listaCategoria.set(listaCategoria.indexOf(nombreViejo), nombreNuevo);
    }

    public static List<String> getCategorias() {
        return listaCategoria;
    }

    public static Integer bajarCategoria(final Integer valor) {
        Integer valorNuevo = valor;

        if (0 < valor && valor - 1 < listaCategoria.size()) {
            valorNuevo = valor - 1;
        }

        return valorNuevo;
    }

    public static Integer subirCategoria(final Integer valor) {
        Integer valorNuevo = valor;

        if (0 <= valor && valor + 1 < listaCategoria.size()) {
            valorNuevo = valor + 1;
        }

        return valorNuevo;

    }

    @SuppressWarnings("null")
    public static void main(final String[] args) {
        Categoria.addCategoria("Basico");
        Categoria.addCategoria("Medio");
        Categoria.addCategoria("Experto");

        for (String nombreCategoria : Categoria.getCategorias()) {
            System.out.println(nombreCategoria);
        }

        final Integer experiencia = 0;
        System.out.println(experiencia + " " + Categoria.nombreCategoria(experiencia));

    }
}