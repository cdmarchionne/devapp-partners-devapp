package ar.edu.unq.partnersdevapp.dominio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: description
 * 
 * @param <T>
 */
public class ListaUtils<T> {

    static public List<Integer> sacarMayoresDe(final List<Integer> list, final int valor) {
        list.retainAll(ListaUtils.sacarMayoresDeAux(list, valor));
        return list;
    }

    static public List<Integer> sacarMenoresDe(final List<Integer> list, final int valor) {
        list.removeAll(ListaUtils.sacarMayoresDeAux(list, valor - 1));
        return list;
    }

    /** Devuelve la lista sin los números maroyes al parametro */
    static private List<Integer> sacarMayoresDeAux(final List<Integer> list, final int valor) {
        List<Integer> intlistRes = new ArrayList<Integer>();
        for (Integer integer : list) {
            if (integer <= valor) {
                intlistRes.add(integer);
            }
        }
        return intlistRes;
    }

}
