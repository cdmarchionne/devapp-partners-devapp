package ar.edu.unq.partnersdevapp.test.licencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaContenedor;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayDiasQueComputarException;

/**
 * TODO: description
 */
public class licenciaTest extends TestCase {
    private static final String FECHA_07_04_2011 = "07/04/2011";

    private static final String FECHA_08_04_2011 = "08/04/2011";

    private static final String FECHA_09_04_2011 = "09/04/2011";

    public void testCrearLicencia() throws NoHayDiasQueComputarException {
        LicenciaTipo licTipo = BaseDeDatosHelper.getEstudio();
        LicenciaContenedor licContenedor = new LicenciaContenedor();

        List<Integer> list = this.getListJuevesViernes();

        FechasXcomprension fechas = new FechasXcomprension();
        fechas.set(FechaUtils.crearFecha(FECHA_07_04_2011), list, Intervalo.getUnaSemana(),
                FechaUtils.crearFecha(FECHA_08_04_2011));

        assertTrue(licContenedor.addLicencia(licTipo, fechas));

        list.add(Calendar.SATURDAY);
        fechas.set(FechaUtils.crearFecha(FECHA_07_04_2011), list, Intervalo.getUnaSemana(),
                FechaUtils.crearFecha(FECHA_09_04_2011));

        assertFalse(licContenedor.addLicencia(licTipo, fechas));
    }

    public void testLicenciaMaximos() throws NoHayDiasQueComputarException {
        LicenciaTipo licTipo = BaseDeDatosHelper.getMudanza();
        LicenciaContenedor licContenedor = new LicenciaContenedor();

        List<Integer> list = this.getListJuevesViernes();

        FechasXcomprension fechas = new FechasXcomprension();
        fechas.set(FechaUtils.crearFecha(FECHA_07_04_2011), list, Intervalo.getUnaSemana(),
                FechaUtils.crearFecha(FECHA_08_04_2011));

        // tiene 5 anual maxino.
        // +2
        assertTrue(licContenedor.addLicencia(licTipo, fechas));
        // +2
        assertTrue(licContenedor.addLicencia(licTipo, fechas));
        // +2
        assertFalse(licContenedor.addLicencia(licTipo, fechas));

        fechas.set(FechaUtils.crearFecha(FECHA_07_04_2011), list, Intervalo.getUnaSemana(),
                FechaUtils.crearFecha(FECHA_07_04_2011));
        // +1
        assertTrue(licContenedor.addLicencia(licTipo, fechas));
    }

    // *******************************
    // ********** Helpers

    private List<Integer> getListJuevesViernes() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.THURSDAY);
        list.add(Calendar.FRIDAY);
        return list;
    }
}
