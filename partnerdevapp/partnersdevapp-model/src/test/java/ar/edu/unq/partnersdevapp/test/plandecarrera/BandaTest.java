package ar.edu.unq.partnersdevapp.test.plandecarrera;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Banda;

/**
 * Tests sobre bandas.
 */
public class BandaTest extends TestCase {

    /** con 0 sub-bandas */
    public void testBanda0() {
        Banda banda = new Banda(0);

        List<Integer> deberiaSer = new ArrayList<Integer>();

        assertEquals("", banda.getBandas(), deberiaSer);
        assertEquals("", banda.getSubNivelSuperior(0), -1);
    }

    /** con 1 sub-bandas */
    public void testBanda1() {
        Banda banda = new Banda(1);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(100);

        assertEquals("", banda.getBandas(), deberiaSer);
        // assertEquals("", banda.getSubNivelSuperior(0), -1);
        assertEquals("", banda.getSubNivelSuperior(100), -1);
    }

    /** con 2 sub-bandas */
    public void testBanda2() {
        Banda banda = new Banda(2);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(100);

        assertEquals("", banda.getBandas(), deberiaSer);
        assertEquals("", banda.getSubNivelSuperior(0), 100);
        assertEquals("", banda.getSubNivelSuperior(100), -1);
    }

    /** con 3 subBandas */
    public void testBanda3() {
        Banda banda = new Banda(3);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(50);
        deberiaSer.add(100);

        assertEquals("", banda.getBandas(), deberiaSer);
        assertEquals("", banda.getSubNivelSuperior(0), 50);
        assertEquals("", banda.getSubNivelSuperior(50), 100);
    }

    /** con 4 subBandas */
    public void testBanda4() {
        Banda banda = new Banda(4);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(33);
        deberiaSer.add(66);
        deberiaSer.add(100);

        assertEquals("", banda.getBandas(), deberiaSer);
        assertEquals("", banda.getSubNivelSuperior(0), 33);
        assertEquals("", banda.getSubNivelSuperior(33), 66);
        assertEquals("", banda.getSubNivelSuperior(66), 100);
    }

    /** con 5 subBandas */
    public void testBanda5() {
        Banda banda = new Banda(5);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(25);
        deberiaSer.add(50);
        deberiaSer.add(75);
        deberiaSer.add(100);

        assertEquals("", banda.getBandas(), deberiaSer);
    }

}