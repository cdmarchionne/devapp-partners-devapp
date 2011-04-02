package ar.edu.unq.partnersdevapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

public class FechaUtilsTest extends TestCase {
    Calendar calendario0;

    @Override
    protected void setUp() throws Exception {
        calendario0 = Calendar.getInstance();
    }

    public void testCrearFecha() {
        @SuppressWarnings("deprecation")
        Date date0 = new Date(99, 4, 5);
        Date date1 = FechaUtils.crearFecha("05/05/1999");
        assertTrue(date0.equals(date1));
    }

    public void testIrAlDomingo() {
        calendario0 = FechaUtils.irAlDomingo(calendario0);
        boolean condicion = calendario0.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
        assertTrue(condicion);
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
        assertTrue(listDate.equals(deberiaSer));

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

        assertTrue(listDate.equals(deberiaSer));

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
        assertTrue(listDate.equals(deberiaSer));
    }

}
