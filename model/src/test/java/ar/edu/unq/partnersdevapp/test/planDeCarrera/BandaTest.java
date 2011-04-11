package ar.edu.unq.partnersdevapp.test.planDeCarrera;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.SubNivel;

/**
 * TODO: description
 */
public class BandaTest extends TestCase {

    /** con 0 sub-bandas */
    public void testBanda0() {
        SubNivel banda = new SubNivel(0);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
        assertTrue(banda.getSubNivelSuperior(0) == 100);
    }

    /** con 1 sub-bandas */
    public void testBanda1() {
        SubNivel banda = new SubNivel(1);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
        assertTrue(banda.getSubNivelSuperior(100) == -1);
    }

    /** con 2 subBandas */
    public void testBanda2() {
        SubNivel banda = new SubNivel(2);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(50);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
        assertTrue(banda.getSubNivelSuperior(0) == 50);
        assertTrue(banda.getSubNivelSuperior(50) == 100);
    }

    /** con 3 subBandas */
    public void testBanda3() {
        SubNivel banda = new SubNivel(3);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(33);
        deberiaSer.add(66);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));
        assertTrue(banda.getSubNivelSuperior(0) == 33);
        assertTrue(banda.getSubNivelSuperior(33) == 66);
        assertTrue(banda.getSubNivelSuperior(66) == 100);

    }

    /** con 4 subBandas */
    public void testBanda4() {
        SubNivel banda = new SubNivel(4);

        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(0);
        deberiaSer.add(25);
        deberiaSer.add(50);
        deberiaSer.add(75);
        deberiaSer.add(100);

        assertTrue(banda.getBandas().equals(deberiaSer));

    }

}