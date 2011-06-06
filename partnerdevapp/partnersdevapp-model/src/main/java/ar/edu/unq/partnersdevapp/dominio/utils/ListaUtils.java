package ar.edu.unq.partnersdevapp.dominio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Contiene utilidades para manejar listas.
 * XXX CommosCollections, CollectionsUtils, Collections, etc etc
 */
public class ListaUtils<T> {

    private ListaUtils() {
        throw new UnsupportedOperationException();
    }

    public static List<Integer> sacarMayoresDe(final List<Integer> list, final int valor) {
        list.retainAll(ListaUtils.sacarMayoresDeAux(list, valor));
        return list;
    }

    public static List<Integer> sacarMenoresDe(final List<Integer> list, final int valor) {
        list.removeAll(ListaUtils.sacarMayoresDeAux(list, valor - 1));
        return list;
    }

    /** Devuelve la lista sin los números maroyes al parametro */
    private static List<Integer> sacarMayoresDeAux(final List<Integer> list, final int valor) {
        List<Integer> intlistRes = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (integer <= valor) {
                intlistRes.add(integer);
            }
        }
        return intlistRes;
    }

    public static List<Integer> interseccion(final List<Integer> listA, final List<Integer> listB) {
        List<Integer> resultadoList = new ArrayList<Integer>();
        for (Integer date : listB) {
            if (listA.contains(date)) {
                resultadoList.add(date);
            }
        }
        return resultadoList;
    }

}
