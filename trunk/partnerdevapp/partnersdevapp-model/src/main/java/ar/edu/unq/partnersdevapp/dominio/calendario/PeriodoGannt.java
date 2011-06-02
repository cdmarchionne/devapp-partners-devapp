package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.Date;

/**
 * Datos necesarios para realizar un grafico Gannt
 */
public class PeriodoGannt {

    private String descripcion;

    private Date fechaInicio;

    private Date fechaFin;

    public PeriodoGannt(final String descripcion, final Date fechaInicio, final Date fechaFin) {
        super();
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    protected String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
