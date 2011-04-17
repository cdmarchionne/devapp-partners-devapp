package ar.edu.unq.partnersdevapp.dominio.basededatos;

import java.util.Map;

import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.SubNivel;

/**
 * Para simular una entrada por base de datos. Podria ser una clase intermedia
 * que le pida ciertas cosas a la base
 */
public class BaseNiveles {

    // mapea jerarquia con nivel(nombre)
    private Map<Integer, String> niveles;

    // esto lo haria una conexcion real
    public String getNivel(final int nivel) {
        return this.getNiveles().get(nivel);
    }

    // niveles predeterminados
    public static Nivel getNivelJunior() {
        return new Nivel("junior", new SubNivel(2), 0);
    }

    public static Nivel getNivelSemiSenior() {
        return new Nivel("semiSenior", new SubNivel(2), 1);
    }

    public static Nivel getNivelSenior() {
        return new Nivel("senior", new SubNivel(3), 2);
    }

    public static Nivel getNiveLider() {
        return new Nivel("lider", new SubNivel(4), 3);
    }

    // **************************
    // ******* Gets & Sets
    public Map<Integer, String> getNiveles() {
        return niveles;
    }

    public void setNiveles(final Map<Integer, String> niveles) {
        this.niveles = niveles;
    }

}
