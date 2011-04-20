package ar.edu.unq.partnersdevapp.dominio.carrera;

import java.util.ArrayList;
import java.util.List;

/**
 * Manejo de Categorias. Se pueden agregar, borrar, cambiar el nombre (Metodos
 * de Clase) Cuando se crea una categoria se le pasa el nombre y dps se puede
 * subir o bajar el nivel de experiencia
 */
public class Categoria {

    private static List<String> listaCategoria = new ArrayList<String>();

    private String categoriaActual;

    public Categoria(final String categoriaActual) {
        super();
        this.categoriaActual = categoriaActual;

    }

    public static Integer indiceCategoria(final String nombreCategoria) {
        return listaCategoria.indexOf(nombreCategoria);
    }

    public static String nombreCategoria(final Integer indice) {
        return listaCategoria.get(indice);
    }

    public static boolean existeCategoria(final String nombre) {
        return listaCategoria.contains(nombre);
    }

    public static String maxima() {
        return listaCategoria.get(listaCategoria.size() - 1);
    }

    public static String minima() {
        return listaCategoria.get(0);
    }

    public static void addCategoria(final String nombre) {
        addCategoria(listaCategoria.size(), nombre);
    }

    public static void addCategoria(final Integer posicion, final String nombre) {
        if (!existeCategoria(nombre) && validarIndiceAddCat(posicion)) {
            listaCategoria.add(posicion, nombre);
        }
    }

    public static boolean removeCategoria(final String nombre) {
        return listaCategoria.remove(nombre);
    }

    public static void renameCategoria(final String nombreViejo, final String nombreNuevo) {
        listaCategoria.set(listaCategoria.indexOf(nombreViejo), nombreNuevo);
    }

    public String getCategoriaActual() {
        return categoriaActual;
    }

    public void bajarCategoria() {
        Integer indiceCategoria = indiceCategoria(categoriaActual);

        if (this.validarIndice(indiceCategoria - 1)) {
            categoriaActual = nombreCategoria(indiceCategoria - 1);
        }

    }

    public void subirCategoria() {
        Integer indiceCategoria = indiceCategoria(categoriaActual);

        if (this.validarIndice(indiceCategoria + 1)) {
            categoriaActual = nombreCategoria(indiceCategoria + 1);
        }

    }

    public boolean cumbreNecesidades(final Categoria requisito) {
        return indiceCategoria(categoriaActual) >= indiceCategoria(requisito.getCategoriaActual());
    }

    private boolean validarIndice(final Integer indice) {
        return 0 <= indice && indice < listaCategoria.size();
    }

    private static boolean validarIndiceAddCat(final Integer indice) {
        return 0 <= indice && indice <= listaCategoria.size();
    }
}