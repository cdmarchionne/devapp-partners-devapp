package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

public class FechaUtilsTest extends TestCase {
    private Calendar calendario0;

    @Override
    protected void setUp() throws Exception {
        calendario0 = Calendar.getInstance();
    }

    public void testCrearFecha() {
        @SuppressWarnings("deprecation")
        Date date0 = new Date(99, 4, 5);
        Date date1 = FechaUtils.crearFecha("05/05/1999");

        assertEquals("", date0, date1);

    }

    public void testIrAlDomingo() {
        this.setCalendario0(FechaUtils.irAlDomingo(this.getCalendario0()));
        boolean condicion = calendario0.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        assertTrue("", condicion);
    }

    public void testDiasDeLaSemanaApartirDel() {
        Date date0 = FechaUtils.crearFecha("06/04/2011");

        List<Date> deberiaSer = new ArrayList<Date>();
        deberiaSer.add(FechaUtils.crearFecha("06/04/2011"));
        deberiaSer.add(FechaUtils.crearFecha("08/04/2011"));
        deberiaSer.add(FechaUtils.crearFecha("09/04/2011"));

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.WEDNESDAY);
        list.add(Calendar.FRIDAY);
        list.add(Calendar.SATURDAY);

        List<Date> listDate = FechaUtils.diasDeLaSemanaApartirDel(date0, list);

        assertEquals("", listDate, deberiaSer);

    }

    public void testDiasDeLaSemanaHastaEl() {
        Date date0 = FechaUtils.crearFecha("08/04/2011");

        List<Date> deberiaSer = new ArrayList<Date>();
        deberiaSer.add(FechaUtils.crearFecha("04/04/2011"));
        deberiaSer.add(FechaUtils.crearFecha("08/04/2011"));

        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.MONDAY);
        list.add(Calendar.FRIDAY);
        list.add(Calendar.SATURDAY);

        List<Date> listDate = FechaUtils.diasDeLaSemanaHastaEl(date0, list);

        assertEquals("", listDate, deberiaSer);
    }

    public void testDiasDeLaSemanaX() {
        // Indica semana X
        Date date0 = FechaUtils.crearFecha("29/03/2011");
        // Para comparar resultado
        List<Date> deberiaSer = new ArrayList<Date>();
        deberiaSer.add(FechaUtils.crearFecha("28/03/2011"));
        deberiaSer.add(FechaUtils.crearFecha("01/04/2011"));
        deberiaSer.add(FechaUtils.crearFecha("02/04/2011"));
        // Lista de dias que quiero de esa semana
        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.MONDAY);
        list.add(Calendar.FRIDAY);
        list.add(Calendar.SATURDAY);
        // test
        List<Date> listDate = FechaUtils.diasDeLaSemanaX(date0, list);

        assertEquals("", listDate, deberiaSer);
    }

    public void testConsecutivo() {
        Date date1 = FechaUtils.crearFecha("28/03/2011");
        Date date2 = FechaUtils.crearFecha("29/03/2011");
        Date date3 = FechaUtils.crearFecha("30/03/2011");

        assertTrue(FechaUtils.isConsecutivo(date1, date2));
        assertFalse(FechaUtils.isConsecutivo(date1, date3));
    }

    public Calendar getCalendario0() {
        return calendario0;
    }

    public void setCalendario0(final Calendar calendario0) {
        this.calendario0 = calendario0;
    }

}
