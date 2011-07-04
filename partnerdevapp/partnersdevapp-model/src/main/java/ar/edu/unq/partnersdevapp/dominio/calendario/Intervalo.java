package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.Calendar;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Representa un lapso de tiempo. Ver metodos estaticos como ejemplo de uso.
 * 
 */
public class Intervalo extends Entidad {

    private static final long serialVersionUID = 1L;

    private int tipo;

    private int cantidad;

    public Intervalo() {

    }

    /**
     * Tipo es el entero que corresponde a semana,mes o año
     */
    public Intervalo(final int aTipo, final int aCantidad) {
        tipo = aTipo;
        cantidad = aCantidad;
    }

    // ********************
    // ******* Utils
    public static Intervalo getUnaSemana() {
        // ver diferencia con WEEK_OF_YEAR
        return new Intervalo(Calendar.WEEK_OF_MONTH, 1);
    }

    public static Intervalo getUnAnio() {
        return new Intervalo(Calendar.YEAR, 1);
    }

    // ***************
    // **** Gets & Sets
    public int getTipo() {
        return tipo;
    }

    public void setTipo(final int tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }

}
