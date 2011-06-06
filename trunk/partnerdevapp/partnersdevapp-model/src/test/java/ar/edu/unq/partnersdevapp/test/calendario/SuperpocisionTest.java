package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.PeriodoIndeterminadoException;

/**
 * Test de Superpocision de FechasXcomprension
 */
public class SuperpocisionTest extends TestCase {
    private static final String FECHA_04_04_2011 = "04/04/2011";

    private static final String FECHA_11_04_2011 = "11/04/2011";

    private static final String FECHA_12_04_2011 = "12/04/2011";

    private static final String FECHA_13_04_2011 = "13/04/2011";

    private static final String FECHA_14_04_2011 = "14/04/2011";

    private static final String FECHA_15_04_2011 = "15/04/2011";

    private static final String FECHA_18_04_2011 = "18/04/2011";

    private static final String MENSAJE = "test de interseccion";

    public void testSuperposicion() throws PeriodoIndeterminadoException {
        FechasXcomprension fxc0 = new FechasXcomprension();
        fxc0.set(FechaUtils.crearFecha(FECHA_04_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        FechasXcomprension fxc1 = new FechasXcomprension();
        fxc1.set(FechaUtils.crearFecha(FECHA_11_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        // assertTrue(MENSAJE, fxc0.seSuperpone(fxc1));

        FechasXcomprension fxc2 = new FechasXcomprension();
        fxc2.set(FechaUtils.crearFecha(FECHA_18_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        assertFalse(MENSAJE, fxc0.seSuperpone(fxc2));
    }

    public void testInterseccion() throws PeriodoIndeterminadoException {
        FechasXcomprension fxc0 = new FechasXcomprension();
        fxc0.set(FechaUtils.crearFecha(FECHA_04_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        FechasXcomprension fxc1 = new FechasXcomprension();
        fxc1.set(FechaUtils.crearFecha(FECHA_11_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        assertTrue(MENSAJE, fxc0.interseccion(fxc1).containsAll(deberSerList));

        FechasXcomprension fxc2 = new FechasXcomprension();
        fxc2.set(FechaUtils.crearFecha(FECHA_18_04_2011), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        assertTrue(MENSAJE, fxc0.interseccion(fxc2).isEmpty());
    }

    // HACER TEST DE SUPERPOSICION CON LOS 2 CONSTRUCTORES DIFERENTES

}
