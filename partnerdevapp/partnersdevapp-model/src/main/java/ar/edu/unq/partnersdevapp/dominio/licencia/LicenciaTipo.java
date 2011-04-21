package ar.edu.unq.partnersdevapp.dominio.licencia;

/**
 * Modela un TIPO de licencia configurable.
 */
public class LicenciaTipo {

    private String tipo;

    private String descripcion;

    private boolean remunerable;

    private int diasConsecutivos;

    private int diasCantidadAnuales;

    /**
     * tipo : motivo remunerable: se se le paga en esos dias de ausencia.<br/>
     * diasConsecutivos y diasCantidad Son anuales. (-1) para el caso de
     * inderminado<br/>
     */
    public LicenciaTipo(final String tipo, final boolean remunerable, final int diasConsecutivos, final int diasCantidad) {
        this.tipo = tipo; // this.setTipo(tipo);
        this.remunerable = remunerable; // this.setRemunerable(remunerable);
        this.diasConsecutivos = diasConsecutivos; // this.setDiasConsecutivos(diasConsecutivos);
        diasCantidadAnuales = diasCantidad; // this.setDiasCantidadAnuales(diasCantidad);
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
