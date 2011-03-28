package ar.edu.unq.partnersdevapp.dominio.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TODO: description
 */
public class FechaUtils {

    /** Crea una fecha a partir de un string con la dorma dd/MM/yyyy */
    static public Date crearFecha(final String strFecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = formatoDelTexto.parse(strFecha);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return d;
    }

    /**
     * Devuelve la lista de fechas correspondiente a cada numero de día de la
     * semana de una fecha. Ej: 30/3/2011 [2,4,6] devuelve [28/3 , 30/3 , 2/4 ]
     * 
     * @param
     */
    static public List<Date> diasSemana(final Date date, final List<Integer> listDate) {
        List<Date> listRes = new ArrayList<Date>();
        Calendar calendarAux = Calendar.getInstance();
        calendarAux.setTime(date);
        calendarAux = FechaUtils.irAlDomingo(calendarAux);
        for (Integer dia : listDate) {
            calendarAux.add(Calendar.DATE, dia - 1);
            listRes.add(calendarAux.getTime());
            calendarAux = FechaUtils.irAlDomingo(calendarAux);
        }
        return listRes;
    }

    static private Calendar irAlDomingo(final Calendar cal) {
        int pos = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, 1 - pos);
        return cal;
    }
}