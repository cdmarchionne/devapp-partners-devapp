package ar.edu.unq.partnersdevapp.dominio.licencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayDiasQueComputarException;

/**
 * Contiene los métodos para validar las licencias.
 */
public class LicenciaContenedor {

    List<InfoLicencia> infoLicencias = new ArrayList<InfoLicencia>();

    public LicenciaContenedor() {

    }

    /**
     * Agrega una licencia al contenedor. Devuele True si la operacion se
     * realizo con exito Si no cumple con los maximos de dias configurados
     * devuelve False
     * 
     * @throws NoHayDiasQueComputarException
     */
    public boolean addLicencia(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas)
            throws NoHayDiasQueComputarException {
        boolean res = false;
        if (this.isDiasConsecutivosValido(aLicenciaTipo, fechas) && this.isDiasAnualesValido(aLicenciaTipo, fechas)) {
            this.getInfoLicencias().add(new InfoLicencia(aLicenciaTipo, fechas));
            res = true;
        }

        return res;
    }

    // TODO: ver si esta bien usado el equals ! Se supone que es el mismo de la
    // misma base.
    private boolean isDiasAnualesValido(final LicenciaTipo aLicenciaTipo, final FechasXcomprension fechas) {
        boolean res;
        if (aLicenciaTipo.getDiasCantidadAnuales() == -1) {
            res = true;
        } else {
            List<InfoLicencia> infoLics = this.getInfoLicencias();
            int diaAcumulados = 0;
            for (InfoLicencia info : infoLics) {
                if (this.isMismoAnioYLicenciafinal(aLicenciaTipo, fechas, info)) {
                    diaAcumulados = diaAcumulados + info.getFechas().getDiasTotal();
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
            throws NoHayDiasQueComputarException {
        return aLicenciaTipo.getDiasConsecutivos() == -1
                || fechas.getDiasConsecutivos() <= aLicenciaTipo.getDiasConsecutivos();

    }

    /** */
    public void addComprobante(final InfoLicencia infoLic, final String pathArchivo) {
        // TODO: comprobante;
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

}
