package ar.edu.unq.partnersdevapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

public class FechaUtilsTest extends TestCase {

    public void testFecha() {

        Date date = FechaUtils.crearFecha("29/03/2011");
        List<Integer> list = new ArrayList<Integer>();
        list.add(Calendar.MONDAY);
        list.add(Calendar.FRIDAY);
        list.add(Calendar.SATURDAY);

        System.out.println(" ** " + FechaUtils.diasSemana(date, list));

    }
}
