package ar.edu.unq.partnersdevapp.test.planDeCarrera;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Banda;

/**
 * TODO: description
 */
public class BandaTest extends TestCase {

    /** con 0 sub-bandas */
    public void testBanda0() {
        Banda banda = new Banda(0);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
    }

    /** con 1 sub-bandas */
    public void testBanda1() {
        Banda banda = new Banda(1);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
    }

    /** con 2 subBandas */
    public void testBanda2() {
        Banda banda = new Banda(2);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(50);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
    }

    /** con 3 subBandas */
    public void testBanda3() {
        Banda banda = new Banda(3);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(33);
        deberiaSer.add(66);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
    }

    /** con 4 subBandas */
    public void testBanda4() {
        Banda banda = new Banda(4);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(25);
        deberiaSer.add(50);
        deberiaSer.add(75);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
    }
}
