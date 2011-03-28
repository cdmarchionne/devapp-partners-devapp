package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TODO: description
 */
public class Fechas {
    private Date fechaInicio;

    private List<Integer> dias;

    private int intervalo; // cantidad de dias

    private Date fechaFin;

    private int repeticiones;

    public Fechas() {
        throw new UnsupportedOperationException();
    }

    /** Dos formas de poner fin . Esta es con cantidad de repeticones */
    public Fechas(final Date fI, final List<Integer> dias, final int intervalo, final int repeticiones) {
        this.setFechaInicio(fI);
        this.setDias(dias);
        this.setIntervalo(intervalo);
        this.setRepeticiones(repeticiones);
    }

    public List<Date> fechasXextencion() {
        List<Date> list = new ArrayList<Date>();

        return list;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<Integer> getDias() {
        return dias;
    }

    public void setDias(final List<Integer> dias) {
        this.dias = dias;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(final int intervalo) {
        this.intervalo = intervalo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(final int repeticiones) {
        this.repeticiones = repeticiones;
    }

}
