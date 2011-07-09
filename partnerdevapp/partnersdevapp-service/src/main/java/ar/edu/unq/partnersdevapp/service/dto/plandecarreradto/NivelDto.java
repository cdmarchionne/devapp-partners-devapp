package ar.edu.unq.partnersdevapp.service.dto.plandecarreradto;

import ar.edu.unq.partnersdevapp.service.dto.Dto;

/**
 * clase Dto con la cual se comunica la vista.
 */
public class NivelDto implements Dto {

    private static final long serialVersionUID = 1L;

    private int id; // NOPMD

    private String nombre;

    /** originalmente es una clase */
    private int banda;

    private int sueldoMaximo;

    private int sueldoMinimo;

    private String lugar;

    public NivelDto(final String nombre2, final int aBanda, final int sueldoMaximo2, final int sueldoMinimo2) {
        nombre = nombre2;
        banda = aBanda;
        sueldoMaximo = sueldoMaximo2;
        sueldoMinimo = sueldoMinimo2;
    }

    @Override
    public String toString() {
        return nombre;
    }

    // *** G y S
    public void setId(final int id) {// NOPMD
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public int getBanda() {
        return banda;
    }

    public void setBanda(final int banda) {
        this.banda = banda;
    }

    public int getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(final int sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    public int getSueldoMinimo() {
        return sueldoMinimo;
    }

    public void setSueldoMinimo(final int sueldoMinimo) {
        this.sueldoMinimo = sueldoMinimo;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setLugar(final String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }
}
