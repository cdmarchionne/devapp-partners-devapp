package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

/**
 * Modela una lista de fechas por comprensión. No soporta fecha de fin
 * indefinida o infinita.
 */
public class FechasXcomprension {
    private Date fechaInicio;

    private List<Integer> dias;

    private int intervalo; // cantidad de dias

    private Date fechaFin;

    private int repeticiones;

    public FechasXcomprension() {

    }

    /**
     * La fecha de inicio se calcula con el número de repeticiones. intervalo es
     * en número de días.
     * 
     * @param
     * */

    /** seteo de fin por repeticiones */
    public void set(final Date inicio, final List<Integer> dias, final int intervalo, final int repeticiones) {
        this.setFechaInicio(inicio);
        this.setDias(dias);
        this.setIntervalo(intervalo);
        this.setRepeticiones(repeticiones);
    }

    /** seteo de fin por fecha */
    public void set(final Date inicio, final List<Integer> dias, final int intervalo, final Date fechaFin) {
        this.setFechaInicio(inicio);
        this.setDias(dias);
        this.setIntervalo(intervalo);
        this.setFechaFin(fechaFin);
        this.setRepeticiones(this.calcularRepeticiones());
    }

    /**
     * Calcula todas las fechas y las devuelve.
     * */
    public List<Date> getFechasXextencion() {
        List<Date> list = new ArrayList<Date>();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this.getFechaInicio());

        list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), this.getDias()));
        calendario.add(Calendar.DATE, intervalo);

        for (int i = 1; i < this.getRepeticiones() - 1; i++) {
            list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
            calendario.add(Calendar.DATE, intervalo);
        }

        if (this.getFechaFin() == null) {
            list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
        } else {
            list.addAll(FechaUtils.diasDeLaSemanaHastaEl(this.getFechaFin(), this.getDias()));
        }

        return list;
    }

    private int calcularRepeticiones() {
        return FechaUtils.getCalendar(this.getFechaFin()).get(Calendar.WEEK_OF_MONTH)
                - FechaUtils.getCalendar(this.getFechaInicio()).get(Calendar.WEEK_OF_MONTH) + 1;
    }

    // Gets & sets
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
