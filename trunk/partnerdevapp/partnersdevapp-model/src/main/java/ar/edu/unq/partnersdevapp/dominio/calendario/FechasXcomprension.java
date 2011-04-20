package ar.edu.unq.partnersdevapp.dominio.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayDiasQueComputarException;

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

    private int repeticiones;

    /** seteo de fin por repeticiones */
    public void set(final Date inicio, final List<Integer> dias, final Intervalo intervalo, final int repeticiones) {
        this.setFechaInicio(inicio);
        this.setDias(dias);
        this.setIntervalo(intervalo);
        this.setRepeticiones(repeticiones);
    }

    /** seteo de fin por fecha */
    public void set(final Date inicio, final List<Integer> dias, final Intervalo intervalo, final Date fechaFin) {
        this.setFechaInicio(inicio);
        this.setDias(dias);
        this.setIntervalo(intervalo);
        this.setFechaFin(fechaFin);
        this.setRepeticiones(this.calcularRepeticiones());
    }

    /**
     * Calcula todas las fechas y las devuelve. No toma fechas anteriores a la
     * fecha de inicio. Si se seto con fecha de fin no toma fechas posterios a
     * la misma, en cambio si se seteo con cantidad de repeticiones tomara
     * fechas posteriores hasta completar la semana de la mismo.
     * */
    public List<Date> getFechasXextencion() {
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
            } else if (!FechaUtils.isMismaSemana(this.getFechaInicio(), this.getFechaFin())) {
                list.addAll(FechaUtils.diasDeLaSemanaHastaEl(this.getFechaFin(), this.getDias()));
            }

        }
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
     * Calcula cuantas semanas se repite. Se usa cuando se crea el constructor
     * con fecha de fin.
     */
    // ******* VER BUG : si las repeticiones son semanas intercaladas?
    private int calcularRepeticiones() {
        return FechaUtils.getCalendar(this.getFechaFin()).get(Calendar.WEEK_OF_MONTH)
                - FechaUtils.getCalendar(this.getFechaInicio()).get(Calendar.WEEK_OF_MONTH) + 1;
    }

    /**
     * Devuele la lista de días resultante de la interseccion con otra fecha por
     * comprensión.
     */

    // TODO :!!! hacer interseccion de listas genericas en el paquete ListUtils
    public List<Date> interseccion(final FechasXcomprension fxc) {
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
     */
    public boolean seSuperpone(final FechasXcomprension fxc) {
        return !this.interseccion(fxc).isEmpty();
    }

    /** Devuelve la cantidad de dias consecutivos a partir del primer día */

    // TODO: no contemplar sabado y domingo. Exepcion lista vacia
    public int getDiasConsecutivos() throws NoHayDiasQueComputarException {
        List<Date> list;
        try {
            list = this.getFechasXextencion();
        } catch (NullPointerException e) {
            throw new NoHayDiasQueComputarException();
        }

        int totalDias = 1;
        int i = 1;
        if (list.size() > 1) {
            Date dateAnterior = list.get(0);
            while (i < list.size() && FechaUtils.isConsecutivo(dateAnterior, list.get(i))) {
                totalDias++;
                i++;
                dateAnterior = list.get(i - 1);
            }
        }
        return totalDias;
    }

    /** Devuelve la cantidad total de dias. */
    public int getDiasTotal() {
        return this.getFechasXextencion().size();
    }

    // *****************************************
    // ********** HELPERS
    private boolean isFechaInicioIgualFin() {
        if (this.getFechaFin() != null)
            return this.getFechaFin().equals(this.getFechaInicio());
        return false;
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

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(final int repeticiones) {
        this.repeticiones = repeticiones;
    }

}
