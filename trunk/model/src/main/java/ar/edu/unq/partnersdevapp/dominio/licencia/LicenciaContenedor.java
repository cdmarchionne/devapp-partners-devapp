package ar.edu.unq.partnersdevapp.dominio.licencia;

import java.util.Map;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;

/**
 * TODO: description
 */
public class LicenciaContenedor {

    Map<LicenciaTipo, InfoLicencia> licencias;

    public LicenciaContenedor() {

    }

    /**
     * Agrega una licencia al contenedor. Devuele True si la operacion se
     * realizo con exito Si no cumple con los maximos de dias configurados
     * devuelve False
     */
    public boolean addLicencia(final LicenciaTipo aLicencia, final FechasXcomprension fechas) {
        // TODO : entes de guardar verivicar que cumpla

        return false;
    }

    public boolean isMaximoDiasValido() {

        return false;
    }

    /** */
    public void addComprobante(final InfoLicencia infoLic, final String pathArchivo) {
        // TODO: comprobante;
    }

    // ******************
    // ****** Gets & Sets
}
