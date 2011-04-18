package ar.edu.unq.partnersdevapp.dominio.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Utilidales para el manejo de fecha.
 */
public class FechaUtils {

    private FechaUtils() {
        throw new UnsupportedOperationException();
    }

    /** Crea una fecha a partir de un string con la dorma dd/MM/yyyy */
    public static Date crearFecha(final String strFecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = null;
        try {
            date = formatoDelTexto.parse(strFecha);
        } catch (ParseException e) {
            // TODO Auto-generated catch block

        }
        return date;
    }

    /**
     * Devuelve la lista de fechas (Date) cada una correspondiente los entero,
     * de una semana indicada con una fecha. Ej: 30/3/2011 [2,4,6] --devuelve
     * [28/3 , 30/3 , 2/4 ]
     * 
     * @param
     */
    /*
     * static public List<Date> diasDeLaSemanaX(final Date date, final
     * List<Integer> listDate) { List<Date> listRes = new ArrayList<Date>();
     * Calendar calendarAux = Calendar.getInstance(); calendarAux.setTime(date);
     * calendarAux = FechaUtils.irAlDomingo(calendarAux); for (Integer dia :
     * listDate) { calendarAux.add(Calendar.DATE, dia - 1);
     * listRes.add(calendarAux.getTime()); calendarAux =
     * FechaUtils.irAlDomingo(calendarAux); } return listRes; }
     */

    public static List<Date> diasDeLaSemanaX(final Date date, final List<Integer> listDate) {
        // Collections.sort(listDate);
        List<Date> listRes = new ArrayList<Date>();
        Calendar calendarAux = Calendar.getInstance();
        calendarAux.setTime(date);
        calendarAux = FechaUtils.irAlDomingo(calendarAux);
        for (Integer dia : listDate) {
            calendarAux.add(Calendar.DATE, dia - calendarAux.get(Calendar.DAY_OF_WEEK));
            listRes.add(calendarAux.getTime());
        }
        return listRes;
    }

    /**
     * Devuelve los dias de la semana indicados, a partir del dia indicado
     * inclusive
     */
    public static List<Date> diasDeLaSemanaApartirDel(final Date date, final List<Integer> listDate) {
        Calendar calendario = FechaUtils.getCalendar(date);
        List<Integer> listCopy = new ArrayList<Integer>();
        listCopy.addAll(listDate);

        ListaUtils.sacarMenoresDe(listCopy, calendario.get(Calendar.DAY_OF_WEEK));
        return FechaUtils.diasDeLaSemanaX(date, listCopy);

    }

    /** Devuelve los dias de la semana indicados, a hasta dia indicado inclusive */
    public static List<Date> diasDeLaSemanaHastaEl(final Date date, final List<Integer> listDate) {
        Calendar calendario = FechaUtils.getCalendar(date);
        List<Integer> listCopy = new ArrayList<Integer>();
        listCopy.addAll(listDate);

        ListaUtils.sacarMayoresDe(listCopy, calendario.get(Calendar.DAY_OF_WEEK));
        return FechaUtils.diasDeLaSemanaX(date, listCopy);

    }

    /** Dado un calendario , lo devuelve posicionado al domingo anterior */
    public static Calendar irAlDomingo(final Calendar cal) {
        int pos = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 1 - pos);
        return cal;
    }

    /** Devuelve un calendario posicionado en una fecha dada */
    public static Calendar getCalendar(final String strFecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(FechaUtils.crearFecha(strFecha));
        return cal;
    }

    /** Devuelve un calendario posicionado en una fecha dada */
    public static Calendar getCalendar(final Date dteFecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dteFecha);
        return cal;
    }

    /** Verifica si dos dias son consecutivos */
    static public boolean isConsecutivo(final Date date1, final Date date2) {
        Calendar cal = FechaUtils.getCalendar(date1);
        Calendar cal2 = FechaUtils.getCalendar(date2);
        return cal2.get(Calendar.DATE) - cal.get(Calendar.DATE) == 1;
    }

    /**
     * Reprecenta la semana de domingo a sábado como lista de enteros. Util para
     * trabajar con un calendario
     */
    public static List<Integer> getDiasDeLaSemana() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        return list;
    }

    /**
     * Reprecenta la semana de lunes a viernes como lista de enteros. Util para
     * trabajar con un calendario
     */
    public static List<Integer> getDiasHabiles() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        return list;
    }

}