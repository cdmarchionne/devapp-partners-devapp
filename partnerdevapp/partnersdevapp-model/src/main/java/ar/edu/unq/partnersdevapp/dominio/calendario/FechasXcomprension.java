package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Modela una lista de fechas por comprensión. No soporta fecha de fin
 * indefinida o infinita. Es recomendable que la fecha de inicio coincida con el
 * menor de los dias de la semana elegidos.
 */
public class FechasXcomprension {
    private Date fechaInicio;

    private List<Integer> dias;

    private Intervalo intervalo;

    private Date fechaFin;

    private Integer repeticiones;

    /** seteo de fin por repeticiones */
    public void set(final Date inicio, final List<Integer> aDias, final Intervalo aIntervalo, final int aRepeticiones) {
        setParametrosEnComun(inicio, aDias, aIntervalo);

        setRepeticiones(aRepeticiones);
    }

    /** seteo de fin por fecha */
    public void set(final Date inicio, final List<Integer> aDias, final Intervalo aIntervalo, final Date aFechaFin) {
        setParametrosEnComun(inicio, aDias, aIntervalo);

        setFechaFin(aFechaFin);
        if (aFechaFin != null) {
            setRepeticiones(calcularRepeticiones());
        }
    }

    /**
     * A una licencia indeterminada se le pone una fecha de fin.<br>
     * Toma por defecto desde la fecha de inicio , todos los días , hasta la
     * fecha de fin.<br>
     * Por ejemplo : tienia baja medica indetermina, vuelve a trabajar, entonces
     * queda el periodo bien definido.
     * 
     * @param
     */
    public final void definirFechaFin(final Date dateFin) {
        setDias(FechaUtils.getDiasDeLaSemana());
        setIntervalo(Intervalo.getUnaSemana());
        setFechaFin(dateFin);
        setRepeticiones(calcularRepeticiones());
    }

    /**
     * Calcula todas las fechas y las devuelve. No toma fechas anteriores a la
     * fecha de inicio. Si se seto con fecha de fin no toma fechas posterios a
     * la misma, en cambio si se seteo con cantidad de repeticiones tomara
     * fechas posteriores hasta completar la semana de la mismo.
     * 
     * @throws PeriodoIndeterminadoException
     * */
    public List<Date> getFechasXextencion() throws PeriodoIndeterminadoException {
        List<Date> list = new ArrayList<Date>();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(getFechaInicio());

        if (isPeriodoIndeterminado()) {
            throw new PeriodoIndeterminadoException();
        } else {
            if (isFechaInicioIgualFin()) {
                list.add(getFechaInicio());
            } else {
                list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), getDias()));
                calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());

                for (int i = 1; i < getRepeticiones() - 1; i++) {
                    list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
                    calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());
                }

                if (getFechaFin() == null) {
                    list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
                } else if (!FechaUtils.isMismaSemana(getFechaInicio(), getFechaFin())) {
                    list.addAll(FechaUtils.diasDeLaSemanaHastaEl(getFechaFin(), getDias()));
                }
            }
        }

        return list;
    }

    public List<Date> getFechasXextencionBACKUP() {
        List<Date> list = new ArrayList<Date>();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(getFechaInicio());

        if (isFechaInicioIgualFin()) {
            list.add(getFechaInicio());
        } else {
            list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), getDias()));
            calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());

            for (int i = 1; i < getRepeticiones() - 1; i++) {
                list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
                calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());
            }

            if (getFechaFin() == null) {
                list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
            } else {
                list.addAll(FechaUtils.diasDeLaSemanaHastaEl(getFechaFin(), getDias()));
            }

        }
        return list;
    }

    /**
     * Devuele la lista de días resultante de la interseccion con otra fecha por
     * comprensión.
     * 
     * @throws PeriodoIndeterminadoException
     */

    public List<Date> interseccion(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        List<Date> resultadoList = new ArrayList<Date>();
        List<Date> thisList = new ArrayList<Date>();
        thisList.addAll(getFechasXextencion());

        for (Date date : fxc.getFechasXextencion()) {
            if (thisList.contains(date)) {
                resultadoList.add(date);
            }
        }
        return resultadoList;
    }

    /**
     * Devielve True si hay por lo menos un día en cumún entre las dos fechas
     * por comprensión.
     * 
     * @throws PeriodoIndeterminadoException
     */
    public boolean seSuperpone(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        return !interseccion(fxc).isEmpty();
    }

    public boolean isPeriodoIndeterminado() {
        return getFechaFin() == null && getRepeticiones() == null;
    }

    /**
     * Devuelve la cantidad de dias consecutivos a partir del primer día No
     * contempla sabado y domingo.
     * 
     * @throws PeriodoIndeterminadoException
     */
    public int getDiasConsecutivos() throws PeriodoIndeterminadoException {
        List<Date> list = getFechasXextencion();
        int totalDias = 1;
        int iterador = 1;
        if (list.size() > 1) {
            Date dateAnterior = list.get(0);
            while (iterador < list.size() && FechaUtils.isConsecutivo(dateAnterior, list.get(iterador))) {
                totalDias++;
                iterador++;
                dateAnterior = list.get(iterador - 1);
            }
        }
        return totalDias;
    }

    /**
     * Devuelve la cantidad total de dias.
     * 
     * @throws PeriodoIndeterminadoException
     */
    public int getDiasTotal() throws PeriodoIndeterminadoException {
        return getFechasXextencion().size();
    }

    // *****************************************
    // ********** HELPERS

    private void setParametrosEnComun(final Date inicio, final List<Integer> aDias, final Intervalo aIntervalo) {
        setFechaInicio(inicio);
        setDias(aDias);
        setIntervalo(aIntervalo);
    }

    /**
     * Calcula cuantas semanas se repite. Se usa cuando se crea el constructor
     * con fecha de fin.
     */
    private int calcularRepeticiones() {
        Calendar diaAux = FechaUtils.getCalendar(fechaInicio);
        int repeticionesAux = 1;
        while (diaAux.getTime().before(getFechaFin())) {
            repeticionesAux++;
            diaAux.add(intervalo.getTipo(), getIntervalo().getCantidad());
        }
        return repeticionesAux;
    }

    private boolean isFechaInicioIgualFin() {
        return getFechaFin() != null && getFechaFin().equals(getFechaInicio());

    }

    // ****************
    // **** Gets & sets
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

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(final Intervalo intervalo) {
        this.intervalo = intervalo;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(final Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(final Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

}
