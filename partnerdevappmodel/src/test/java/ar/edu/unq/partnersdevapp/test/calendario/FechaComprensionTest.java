package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;
import ar.edu.unq.partnersdevapp.exceptions.NoHayDiasQueComputarException;

/**
 * test referidos a la creacion de fechas por extencion.
 * 
 * @author leo
 */
public class FechaComprensionTest extends TestCase {

    private static final String FECHA_01_04_2011 = "01/04/2011";

    private static final String FECHA_04_04_2011 = "04/04/2011";

    private static final String FECHA_05_04_2011 = "05/04/2011";

    private static final String FECHA_06_04_2011 = "06/04/2011";

    private static final String FECHA_07_04_2011 = "07/04/2011";

    private static final String FECHA_08_04_2011 = "08/04/2011";

    private static final String FECHA_09_04_2011 = "09/04/2011";

    private static final String FECHA_10_04_2011 = "10/04/2011";

    private static final String FECHA_11_04_2011 = "11/04/2011";

    private static final String FECHA_12_04_2011 = "12/04/2011";

    private static final String FECHA_13_04_2011 = "13/04/2011";

    private static final String FECHA_14_04_2011 = "14/04/2011";

    private static final String FECHA_15_04_2011 = "15/04/2011";

    private static final String FECHA_16_04_2011 = "16/04/2011";

    private static final String FECHA_19_04_2011 = "19/04/2011";

    private static final String FECHA_18_04_2011 = "18/04/2011";

    private static final String FECHA_20_04_2011 = "20/04/2011";

    private static final String FECHA_28_03_2011 = "28/03/2011";

    // terminar
    public void testSetUnDia() {
        Date inicio = FechaUtils.crearFecha(FECHA_05_04_2011);

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.TUESDAY);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_05_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_19_04_2011));

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, list, Intervalo.getUnaSemana(), 3);

        assertTrue("", fxc.getFechasXextencion().containsAll(deberSerList));

    }

    public void testSetDiasManual() {
        Date inicio = FechaUtils.crearFecha(FECHA_28_03_2011);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_28_03_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_01_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_04_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_08_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.MONDAY);
        list.add(Calendar.FRIDAY);

        // Lunes y viernes - cada una semana - durante 3 semanas
        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, list, Intervalo.getUnaSemana(), 3);

        List<Date> fechasXextencion = fxc.getFechasXextencion();

        assertTrue("", fechasXextencion.containsAll(deberSerList));

        fechasXextencion.removeAll(deberSerList);
        assertTrue("", fechasXextencion.isEmpty());

    }

    public void testSetDiasDeLaSemana() {
        Date inicio = FechaUtils.crearFecha(FECHA_04_04_2011);

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasDeLaSemana(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertEquals("", fechasXextencion, this.getDosSemana());

    }

    public void testSetDiasDeLaSemanaHabiles() {
        Date inicio = FechaUtils.crearFecha(FECHA_04_04_2011);

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertEquals("", fechasXextencion, this.getDosSemanaHabiles());

    }

    /* Con fecha de inicio desfasada */
    public void testSetDiasDeLaSemanaHabilesDes() {
        Date inicio = FechaUtils.crearFecha(FECHA_06_04_2011);

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertEquals("", fechasXextencion, this.getDosSemanaHabilesDes());

    }

    public void testCalcularRepeticiones() {
        Date inicio = FechaUtils.crearFecha(FECHA_06_04_2011);
        Date fin = FechaUtils.crearFecha(FECHA_20_04_2011);

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        assertEquals("", fxc.getRepeticiones(), 3);

    }

    // Fecha inicio igual fecha fin
    public void testSetDiasDeLaSemanaHabilesDesConFechaFinIgual() {
        Date inicio = FechaUtils.crearFecha("06/04/2011");
        Date fin = FechaUtils.crearFecha("06/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("06/04/2011"));

        List<Date> fechasXextencion = fxc.getFechasXextencion();

        System.err.println(fechasXextencion);
        assertEquals("", fechasXextencion, deberSerList);

    }

    public void testSetDiasDeLaSemanaHabilesDesConFechaFin() {
        Date inicio = FechaUtils.crearFecha(FECHA_06_04_2011);
        Date fin = FechaUtils.crearFecha(FECHA_20_04_2011);

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        List<Date> fechasXextencion = fxc.getFechasXextencion();

        assertEquals("", fechasXextencion, this.getTresSemanaHabilesDes());

    }

    public void testIsConsecutivo() throws NoHayDiasQueComputarException {

        FechasXcomprension fxc = new FechasXcomprension();

        try {
            fxc.getDiasConsecutivos();
        } catch (Exception e) {
            assertEquals(e.getClass(), NoHayDiasQueComputarException.class);
        }

        Date inicio = FechaUtils.crearFecha("04/04/2011");
        Date fin = FechaUtils.crearFecha("04/04/2011");
        fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        System.out.println(fxc.getDiasConsecutivos());
        assertEquals(fxc.getDiasConsecutivos(), 1);

        inicio = FechaUtils.crearFecha("04/04/2011");
        fin = FechaUtils.crearFecha("05/04/2011");
        fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        System.out.println(fxc.getDiasConsecutivos());
        assertEquals(fxc.getDiasConsecutivos(), 2);

        inicio = FechaUtils.crearFecha("04/04/2011");
        fin = FechaUtils.crearFecha("08/04/2011");
        fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        System.out.println(fxc.getDiasConsecutivos());
        assertEquals(fxc.getDiasConsecutivos(), 5);

    }

    // ***************************************
    // ********* Helpers

    private List<Date> getDosSemana() {
        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_04_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_05_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_06_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_07_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_08_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_09_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_10_04_2011));

        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_16_04_2011));
        // el domingo perteneceria a la tercer semana.
        // deberSerList.add(FechaUtils.crearFecha("17/04/2011"));

        return deberSerList;
    }

    private List<Date> getDosSemanaHabiles() {
        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha(FECHA_04_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_05_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_06_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_07_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_08_04_2011));

        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        return deberSerList;
    }

    private List<Date> getDosSemanaHabilesDes() {
        List<Date> deberSerList = new ArrayList<Date>();

        deberSerList.add(FechaUtils.crearFecha(FECHA_06_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_07_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_08_04_2011));

        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        return deberSerList;
    }

    /** Tres semanas habiles defasadas del 06/04 al 20/04 */
    private List<Date> getTresSemanaHabilesDes() {
        List<Date> deberSerList = new ArrayList<Date>();

        deberSerList.add(FechaUtils.crearFecha(FECHA_06_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_07_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_08_04_2011));

        deberSerList.add(FechaUtils.crearFecha(FECHA_11_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_12_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_13_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_14_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_15_04_2011));

        deberSerList.add(FechaUtils.crearFecha(FECHA_18_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_19_04_2011));
        deberSerList.add(FechaUtils.crearFecha(FECHA_20_04_2011));

        return deberSerList;
    }
}
