package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

/**
 * @author leo TODO: test referidos a la creacion de fechas por extencion.
 */
public class FechaComprensionTest extends TestCase {

    // terminar
    public void testSetUnDia() {
        Date inicio = FechaUtils.crearFecha("05/04/2011");

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.TUESDAY);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("05/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("19/04/2011"));

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, list, Intervalo.getUnaSemana(), 3);

        assertTrue(fxc.getFechasXextencion().containsAll(deberSerList));

    }

    public void testSetDiasManual() {
        Date inicio = FechaUtils.crearFecha("28/03/2011");

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("28/03/2011"));
        deberSerList.add(FechaUtils.crearFecha("01/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("04/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("08/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.MONDAY);
        list.add(Calendar.FRIDAY);

        // Lunes y viernes - cada una semana - durante 3 semanas
        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, list, Intervalo.getUnaSemana(), 3);

        List<Date> fechasXextencion = fxc.getFechasXextencion();

        assertTrue(fechasXextencion.containsAll(deberSerList));

        fechasXextencion.removeAll(deberSerList);
        assertTrue(fechasXextencion.isEmpty());

    }

    public void testSetDiasDeLaSemana() {
        Date inicio = FechaUtils.crearFecha("04/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasDeLaSemana(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertTrue(fechasXextencion.equals(this.getDosSemana()));

    }

    public void testSetDiasDeLaSemanaHabiles() {
        Date inicio = FechaUtils.crearFecha("04/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertTrue(fechasXextencion.equals(this.getDosSemanaHabiles()));

    }

    /* Con fecha de inicio desfasada */
    public void testSetDiasDeLaSemanaHabilesDes() {
        Date inicio = FechaUtils.crearFecha("06/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertTrue(fechasXextencion.equals(this.getDosSemanaHabilesDes()));

    }

    public void testCalcularRepeticiones() {
        Date inicio = FechaUtils.crearFecha("06/04/2011");
        Date fin = FechaUtils.crearFecha("20/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        assertTrue(fxc.getRepeticiones() == 3);

    }

    public void testSetDiasDeLaSemanaHabilesDesConFechaFin() {
        Date inicio = FechaUtils.crearFecha("06/04/2011");
        Date fin = FechaUtils.crearFecha("20/04/2011");

        FechasXcomprension fxc = new FechasXcomprension();
        fxc.set(inicio, FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), fin);

        List<Date> fechasXextencion = fxc.getFechasXextencion();
        fechasXextencion = fxc.getFechasXextencion();

        assertTrue(fechasXextencion.equals(this.getTresSemanaHabilesDes()));

    }

    /* Datos para los test */

    private List<Date> getDosSemana() {
        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("04/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("05/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("06/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("07/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("08/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("09/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("10/04/2011"));

        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("13/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("14/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("16/04/2011"));
        // el domingo perteneceria a la tercer semana.
        // deberSerList.add(FechaUtils.crearFecha("17/04/2011"));

        return deberSerList;
    }

    private List<Date> getDosSemanaHabiles() {
        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("04/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("05/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("06/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("07/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("08/04/2011"));

        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("13/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("14/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));

        return deberSerList;
    }

    private List<Date> getDosSemanaHabilesDes() {
        List<Date> deberSerList = new ArrayList<Date>();

        deberSerList.add(FechaUtils.crearFecha("06/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("07/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("08/04/2011"));

        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("13/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("14/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));

        return deberSerList;
    }

    /** Tres semanas habiles defasadas del 06/04 al 20/04 */
    private List<Date> getTresSemanaHabilesDes() {
        List<Date> deberSerList = new ArrayList<Date>();

        deberSerList.add(FechaUtils.crearFecha("06/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("07/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("08/04/2011"));

        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("13/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("14/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));

        deberSerList.add(FechaUtils.crearFecha("18/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("19/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("20/04/2011"));

        return deberSerList;
    }
}
