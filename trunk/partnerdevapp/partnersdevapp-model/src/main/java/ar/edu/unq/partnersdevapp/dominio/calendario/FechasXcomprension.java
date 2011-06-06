package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Modela una lista de fechas por comprensión. No soporta fecha de fin
 * indefinida o infinita. Es recomendable que la fecha de inicio coincida con el
 * menor de los dias de la semana elegidos.
 * XXX mucho de este comportamiento esta implementado en jodatime
 */
public class FechasXcomprension {

    private Date fechaInicio;

    private List<Integer> dias;

    private Intervalo intervalo;

    private Date fechaFin;

    private Integer repeticiones;

    /**
     * seteo el fin por repeticiones
     * 
     * @throws PeriodoIndeterminadoException
     */
    public void set(final Date inicio, final List<Integer> aDias, final Intervalo aIntervalo, final int aRepeticiones)
            throws PeriodoIndeterminadoException {

        setParametrosEnComun(inicio, aDias, aIntervalo);
        setRepeticiones(aRepeticiones);
        List<Date> fechasXextencion = getFechasXextencion();
        setFechaFin(fechasXextencion.get(fechasXextencion.size() - 1));
    }

    /** seteo el fin por fecha */
    public void set(final Date inicio, final List<Integer> aDias, final Intervalo aIntervalo, final Date aFechaFin) {
        setParametrosEnComun(inicio, aDias, aIntervalo);

        setFechaFin(aFechaFin);
        if (aFechaFin != null && aIntervalo != null) {
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
        if (fechaInicio == null) {
            return new ArrayList<Date>();
        }

        List<Date> list = new ArrayList<Date>();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(getFechaInicio());

        if (isPeriodoIndeterminado()) {
            throw new PeriodoIndeterminadoException();
        }

        if (isFechaInicioIgualFin()) {
            list.add(getFechaInicio());
            return list;
        }

        // primera semana
        list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), getDias()));
        if (FechaUtils.isMismaSemana(getFechaInicio(), getFechaFin())) {
            return list;
        } else {
            calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());
        }
        // semanas intermedias
        for (int i = 1; i < getRepeticiones() - 1; i++) {
            list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
            calendario.add(getIntervalo().getTipo(), getIntervalo().getCantidad());
        }

        // ultima semana
        if (getFechaFin() == null) {
            list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), getDias()));
        } else if (!FechaUtils.isMismaSemana(getFechaInicio(), getFechaFin())) {
            list.addAll(FechaUtils.diasDeLaSemanaHastaEl(getFechaFin(), getDias()));
        }

        return list;
    }

    // TODO : un superpone más liviano
    /**
     * Devuele la lista de días resultante de la interseccion con otra fecha por
     * comprensión.
     * 
     * @throws PeriodoIndeterminadoException
     */
    @SuppressWarnings("unchecked")
    public List<Date> interseccion(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        return ListUtils.intersection(getFechasXextencion(), fxc.getFechasXextencion());
    }

    /**
     * Quita los elementos que coinciden con los pasados por parametros
     */
    @SuppressWarnings("unchecked")
    public List<Date> restar(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        return ListUtils.subtract(getFechasXextencion(), fxc.getFechasXextencion());
    }

    /**
     * Devielve True si hay por lo menos un día en cumún entre las dos fechas
     * por comprensión.
     * 
     * @throws PeriodoIndeterminadoException
     */
    public boolean seSuperpone(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        // return !this.interseccion(fxc).isEmpty();
        return FechaUtils.superpone(getFechaInicio(), getFechaFin(), fxc.getFechaInicio(), fxc.getFechaFin());
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
        if (list.isEmpty()) {
            return 0;
        }
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
        return (Date) fechaInicio.clone();
    }

    public void setFechaInicio(final Date fechaInicio) {
        this.fechaInicio = (Date) fechaInicio.clone();
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
        // return (Date) fechaFin.clone();
        return fechaFin;
    }

    public void setFechaFin(final Date fechaFin) {
        // this.fechaFin = (Date) fechaFin.clone();
        this.fechaFin = fechaFin;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(final Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

}
