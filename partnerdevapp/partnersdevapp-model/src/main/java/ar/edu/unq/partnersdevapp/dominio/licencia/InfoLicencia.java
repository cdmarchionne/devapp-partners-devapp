package ar.edu.unq.partnersdevapp.dominio.licencia;

import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;

/**
 * Informacion licencia.
 */
public class InfoLicencia {

    LicenciaTipo licenciaTipo;

    String rutaArchivoComprobante;

    FechasXcomprension fechas;

    public InfoLicencia(final LicenciaTipo licTipo, final FechasXcomprension aFechas) {
        licenciaTipo = licTipo;
        fechas = aFechas;
    }

    @Override
    public String toString() {
        return "(" + licenciaTipo.getTipo() + "," + fechas.getDiasTotal() + ")";
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
