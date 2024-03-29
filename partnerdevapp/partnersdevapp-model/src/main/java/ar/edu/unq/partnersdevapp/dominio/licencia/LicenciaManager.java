package ar.edu.unq.partnersdevapp.dominio.licencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;
import ar.edu.unq.partnersdevapp.exceptions.NoSeAsignoLicencia;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Maneja las licencias de un empleado.
 * 
 * @author leo
 */
public class LicenciaManager extends Entidad {

    private static final long serialVersionUID = 1L;

    private List<InfoLicencia> infoLicencias = new ArrayList<InfoLicencia>();

    /**
     * Agrega una licencia al contenedor. Devuele True si la operacion se
     * realizo con exito Si no cumple con los maximos de dias configurados
     * devuelve False. No verifica superposicion de fechas!
     * 
     * @throws NoHayResultadoException
     * @throws PeriodoIndeterminadoException
     * @throws NoSeAsignoLicencia
     */
    public boolean addLicencia(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas)
            throws NoHayResultadoException, PeriodoIndeterminadoException, NoSeAsignoLicencia {
        boolean condicion = !this.tieneLicenciaIndeterminada();
        condicion = condicion && this.isDiasConsecutivosValido(aLicenciaTipo, fechas);
        condicion = condicion && this.isDiasAnualesValido(aLicenciaTipo, fechas);

        if (condicion) {
            this.getInfoLicencias().add(new InfoLicencia(aLicenciaTipo, fechas));
        } else {
            throw new NoSeAsignoLicencia();
        }

        return condicion;
    }

    /** Devuelve True si tiene una licencia indeterminada */
    public boolean tieneLicenciaIndeterminada() {
        boolean res = false;
        for (InfoLicencia info : this.getInfoLicencias()) {
            res = res || info.getFechas().isPeriodoIndeterminado();
        }
        return res;
    }

    // misma base.
    private boolean isDiasAnualesValido(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas)
            throws PeriodoIndeterminadoException {
        boolean res;
        List<InfoLicencia> infoLics;
        int diaAcumulados;

        if (aLicenciaTipo.getDiasCantidadAnuales() == -1) {
            res = true;
        } else {
            infoLics = this.getInfoLicencias();
            diaAcumulados = 0;
            for (InfoLicencia info : infoLics) {
                if (this.isMismoAnioYLicenciafinal(aLicenciaTipo, fechas, info)) {
                    diaAcumulados += info.getFechas().getDiasTotal();
                }
            }
            res = diaAcumulados + fechas.getDiasTotal() <= aLicenciaTipo.getDiasCantidadAnuales();
        }
        return res;
    }

    private boolean isMismoAnioYLicenciafinal(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas,
            final InfoLicencia info) {

        return info.getLicenciaTipo().equals(aLicenciaTipo)
                && FechaUtils.isMismoAnio(fechas.getFechaInicio(), info.getFechas().getFechaInicio());
    }

    private boolean isDiasConsecutivosValido(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas)
            throws PeriodoIndeterminadoException {
        return aLicenciaTipo.getDiasConsecutivos() == -1
                || fechas.getDiasConsecutivos() <= aLicenciaTipo.getDiasConsecutivos();

    }

    /**
     * Agrega el path donde se encuentra el archivo del comprobante de dicha
     * licencia
     */
    public void addComprobante(final InfoLicencia infoLic, final String pathArchivo) {
        this.getInfoLicencias().get(infoLicencias.indexOf(infoLic)).setRutaArchivoComprobante(pathArchivo);
    }

    @Override
    public String toString() {
        return this.getInfoLicencias().toString();
    }

    // ******************
    // ****** Gets & Sets
    public List<InfoLicencia> getInfoLicencias() {
        return infoLicencias;
    }

    public void setInfoLicencias(final List<InfoLicencia> infoLicencias) {
        this.infoLicencias = infoLicencias;
    }

    /** Dias que tiene solicitados licencia */
    public List<FechasXcomprension> diasOcupados() {
        List<FechasXcomprension> diasOcupados = new ArrayList<FechasXcomprension>();

        for (InfoLicencia infoLicencia : infoLicencias) {
            diasOcupados.add(infoLicencia.getFechas());
        }
        return diasOcupados;
    }

    /** Dias que tiene solicitados licencia que coinciden con una fecha dada */
    public List<FechasXcomprension> diasOcupados(final FechasXcomprension fechaProyecto)
            throws PeriodoIndeterminadoException {
        List<FechasXcomprension> diasOcupados = new ArrayList<FechasXcomprension>();

        for (InfoLicencia infoLicencia : infoLicencias) {
            if (fechaProyecto.seSuperpone(infoLicencia.getFechas())) {
                diasOcupados.add(infoLicencia.getFechas());
            }
        }
        return diasOcupados;
    }

}
