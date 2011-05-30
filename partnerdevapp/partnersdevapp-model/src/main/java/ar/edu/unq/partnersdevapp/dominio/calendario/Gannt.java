package ar.edu.unq.partnersdevapp.dominio.calendario;

import ar.edu.unq.partnersdevapp.dominio.licencia.InfoLicencia;

/**
 * Datos necesarios para realizar un grafico Gannt EN CONSTRUCCION
 */
public class Gannt {

    private String descripcion;

    private String tipo;

    private InfoLicencia fecha;

    protected String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    protected String getTipo() {
        return tipo;
    }

    protected void setTipo(final String tipo) {
        this.tipo = tipo;
    }

    protected InfoLicencia getFecha() {
        return fecha;
    }

    protected void setFecha(final InfoLicencia fecha) {
        this.fecha = fecha;
    }

}
