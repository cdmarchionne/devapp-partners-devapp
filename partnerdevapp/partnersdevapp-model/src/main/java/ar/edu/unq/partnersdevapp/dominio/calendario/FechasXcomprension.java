package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayDiasQueComputarException;
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
    public void set(final Date inicio, final List<Integer> dias, final Intervalo intervalo, final int repeticiones) {
        this.setParametrosEnComun(inicio, dias, intervalo);

        this.setRepeticiones(repeticiones);
    }

    /** seteo de fin por fecha */
    public void set(final Date inicio, final List<Integer> dias, final Intervalo intervalo, final Date fechaFin) {
        this.setParametrosEnComun(inicio, dias, intervalo);

        this.setFechaFin(fechaFin);
        if (fechaFin != null) {
            this.setRepeticiones(this.calcularRepeticiones());
        }
    }

    /**
     * A una licencia indeterminada se le pone una fecha de fin.<br>
     * Toma por defecto desde la fecha de inicio , todos los días , hasta la
     * fecha de fin.<br>
     * Por ejemplo : tienia baja medica indetermina, vuelve a trabajar, entonces
     * queda el periodo bien definido.
     */
    public void definirFechaFin(final Date dateFin) {
        this.setDias(FechaUtils.getDiasDeLaSemana());
        this.setIntervalo(Intervalo.getUnaSemana());
        this.setFechaFin(dateFin);
        this.setRepeticiones(this.calcularRepeticiones());
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
        calendario.setTime(this.getFechaInicio());

        if (!this.isPeriodoIndeterminado()) {
            if (this.isFechaInicioIgualFin()) {
                list.add(this.getFechaInicio());
            } else {
                list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), this.getDias()));
                calendario.add(this.getIntervalo().getTipo(), this.getIntervalo().getCantidad());

                for (int i = 1; i < this.getRepeticiones() - 1; i++) {
                    list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
                    calendario.add(this.getIntervalo().getTipo(), this.getIntervalo().getCantidad());
                }

                if (this.getFechaFin() == null) {
                    list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
                } else if (!FechaUtils.isMismaSemana(this.getFechaInicio(), this.getFechaFin())) {
                    list.addAll(FechaUtils.diasDeLaSemanaHastaEl(this.getFechaFin(), this.getDias()));
                }

            }
        } else
            throw new PeriodoIndeterminadoException();

        return list;
    }

    public List<Date> getFechasXextencionBACKUP() {
        List<Date> list = new ArrayList<Date>();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(this.getFechaInicio());

        if (this.isFechaInicioIgualFin()) {
            list.add(this.getFechaInicio());
        } else {
            list.addAll(FechaUtils.diasDeLaSemanaApartirDel(calendario.getTime(), this.getDias()));
            calendario.add(this.getIntervalo().getTipo(), this.getIntervalo().getCantidad());

            for (int i = 1; i < this.getRepeticiones() - 1; i++) {
                list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
                calendario.add(this.getIntervalo().getTipo(), this.getIntervalo().getCantidad());
            }

            if (this.getFechaFin() == null) {
                list.addAll(FechaUtils.diasDeLaSemanaX(calendario.getTime(), this.getDias()));
            } else {
                list.addAll(FechaUtils.diasDeLaSemanaHastaEl(this.getFechaFin(), this.getDias()));
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

    // TODO :!!! hacer interseccion de listas genericas en el paquete ListUtils
    public List<Date> interseccion(final FechasXcomprension fxc) throws PeriodoIndeterminadoException {
        List<Date> resultadoList = new ArrayList<Date>();
        List<Date> thisList = this.getFechasXextencion();
        List<Date> paramList = fxc.getFechasXextencion();
        for (Date date : paramList) {
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
        return !this.interseccion(fxc).isEmpty();
    }

    public boolean isPeriodoIndeterminado() {
        return this.getFechaFin() == null && this.getRepeticiones() == null;
    }

    /**
     * Devuelve la cantidad de dias consecutivos a partir del primer día
     * 
     * @throws PeriodoIndeterminadoException
     */

    // TODO: no contemplar sabado y domingo. Exepcion lista vacia
    public int getDiasConsecutivos() throws NoHayDiasQueComputarException, PeriodoIndeterminadoException {
        List<Date> list;
        try {
            list = this.getFechasXextencion();
        } catch (NullPointerException e) {
            throw new NoHayDiasQueComputarException();
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
        return this.getFechasXextencion().size();
    }

    // *****************************************
    // ********** HELPERS

    private void setParametrosEnComun(final Date inicio, final List<Integer> dias, final Intervalo intervalo) {
        this.setFechaInicio(inicio);
        this.setDias(dias);
        this.setIntervalo(intervalo);
    }

    /**
     * Calcula cuantas semanas se repite. Se usa cuando se crea el constructor
     * con fecha de fin.
     */
    private int calcularRepeticiones() {
        Calendar diaAux = FechaUtils.getCalendar(fechaInicio);
        int repeticionesAux = 1;
        while (diaAux.getTime().before(this.getFechaFin())) {
            repeticionesAux++;
            diaAux.add(intervalo.getTipo(), this.getIntervalo().getCantidad());
        }
        return repeticionesAux;
    }

    private boolean isFechaInicioIgualFin() {
        return this.getFechaFin() != null && this.getFechaFin().equals(this.getFechaInicio());

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
