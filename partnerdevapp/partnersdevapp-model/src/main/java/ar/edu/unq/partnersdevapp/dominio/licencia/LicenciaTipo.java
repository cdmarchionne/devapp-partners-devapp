package ar.edu.unq.partnersdevapp.dominio.licencia;

import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;

/**
 * Modela un TIPO de licencia configurable.
 * 
 * @author leo
 */
public class LicenciaTipo extends Entidad {

    private static final long serialVersionUID = 1L;

    private String tipo;

    private String descripcion;

    private boolean remunerable;

    private int diasConsecutivos;

    private int diasCantidadAnuales;

    public LicenciaTipo() {
        super();
    }

    /**
     * tipo : motivo<br/>
     * remunerable: se se le paga en esos dias de ausencia.<br/>
     * diasConsecutivos y diasCantidad Son anuales. (-1) para el caso de
     * inderminado<br/>
     */
    public LicenciaTipo(final String tipo, final boolean remunerable, final int diasConsecutivos, final int diasCantidad) {
        super();
        this.tipo = tipo;
        this.remunerable = remunerable;
        this.diasConsecutivos = diasConsecutivos;
        diasCantidadAnuales = diasCantidad;
    }

    @Override
    public String toString() {
        return this.getTipo();
    }

    // ******************
    // ****** Gets & Sets
    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    public boolean isRemunerable() {
        return remunerable;
    }

    public void setRemunerable(final boolean remunerable) {
        this.remunerable = remunerable;
    }

    public int getDiasConsecutivos() {
        return diasConsecutivos;
    }

    public void setDiasConsecutivos(final int diasConsecutivos) {
        this.diasConsecutivos = diasConsecutivos;
    }

    public int getDiasCantidadAnuales() {
        return diasCantidadAnuales;
    }

    public void setDiasCantidadAnuales(final int diasCantidadAnuales) {
        this.diasCantidadAnuales = diasCantidadAnuales;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

}
