package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.calendario.FechasXcomprension;
import ar.edu.unq.partnersdevapp.dominio.calendario.Intervalo;
import ar.edu.unq.partnersdevapp.dominio.utils.FechaUtils;

/**
 * TODO: description
 */
public class SuperpocisionTest extends TestCase {

    public void testSuperposicionTrue() {

        FechasXcomprension fxc0 = new FechasXcomprension();
        fxc0.set(FechaUtils.crearFecha("04/04/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        FechasXcomprension fxc1 = new FechasXcomprension();
        fxc1.set(FechaUtils.crearFecha("11/04/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        List<Date> deberSerList = new ArrayList<Date>();
        deberSerList.add(FechaUtils.crearFecha("11/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("12/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("13/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("14/04/2011"));
        deberSerList.add(FechaUtils.crearFecha("15/04/2011"));

        System.out.println(fxc0.getFechasXextencion());
        System.out.println(fxc1.getFechasXextencion());
        assertTrue(fxc0.interseccion(fxc1).containsAll(deberSerList));

        assertTrue(fxc0.seSuperpone(fxc1));
    }

    public void testSuperposicionFalse() {

        FechasXcomprension fxc0 = new FechasXcomprension();
        fxc0.set(FechaUtils.crearFecha("04/04/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        FechasXcomprension fxc1 = new FechasXcomprension();
        fxc1.set(FechaUtils.crearFecha("18/04/2011"), FechaUtils.getDiasHabiles(), Intervalo.getUnaSemana(), 2);

        assertTrue(fxc0.interseccion(fxc1).isEmpty());

        assertFalse(fxc0.seSuperpone(fxc1));
    }

    // HACER TEST DE SUPERPOSICION CON LOS 2 CONSTRUCTORES DIFERENTES

}
