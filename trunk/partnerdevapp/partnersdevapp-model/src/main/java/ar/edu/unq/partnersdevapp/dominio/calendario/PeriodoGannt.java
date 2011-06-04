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
        this.fechaInicio = (Date) fechaInicio.clone();
        this.fechaFin = (Date) fechaFin.clone();
    }

    protected String getDescripcion() {
        return descripcion;
    }

    protected void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return (Date) fechaInicio.clone();
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = (Date) fechaInicio.clone();
    }

    public Date getFechaFin() {
        return (Date) fechaFin.clone();
    }

    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = (Date) fechaFin.clone();
    }

}
