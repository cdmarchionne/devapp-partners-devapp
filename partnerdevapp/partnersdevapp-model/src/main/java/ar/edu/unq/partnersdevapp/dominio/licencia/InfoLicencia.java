package ar.edu.unq.partnersdevapp.dominio.licencia;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.entidad.Entidad;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Informacion licencia.
 */
public class InfoLicencia extends Entidad {

    private static final long serialVersionUID = 1L;

    private LicenciaTipo licenciaTipo;

    private String rutaArchivoComprobante;

    private FechasXcomprension fechas;

    public InfoLicencia() {

    }

    public InfoLicencia(final LicenciaTipo licTipo, final FechasXcomprension aFechas) {
        licenciaTipo = licTipo;
        fechas = aFechas;
    }

    @Override
    public String toString() {
        try {
            return "(" + licenciaTipo.getTipo() + "," + fechas.getDiasTotal() + ")";
        } catch (PeriodoIndeterminadoException e) {
            return "(" + licenciaTipo.getTipo() + ", indefinido" + ")";
        }
    }

    public LicenciaTipo getLicenciaTipo() {
        return licenciaTipo;
    }

    public void setLicenciaTipo(final LicenciaTipo licenciaTipo) {
        this.licenciaTipo = licenciaTipo;
    }

    public String getRutaArchivoComprobante() {
        return rutaArchivoComprobante;
    }

    public void setRutaArchivoComprobante(final String rutaArchivoComprobante) {
        this.rutaArchivoComprobante = rutaArchivoComprobante;
    }

    public FechasXcomprension getFechas() {
        return fechas;
    }

    public void setFechas(final FechasXcomprension fechas) {
        this.fechas = fechas;
    }

}
