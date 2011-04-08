package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.utils.ListaUtils;

/**
 * TODO: description
 */
public class ListaUtilTest extends TestCase {
    List<Integer> intlist = new ArrayList<Integer>();

    @Override
    protected void setUp() throws Exception {
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);
        intlist.add(5);
    }

    public void testSacarMayoresDe() {
        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(1);
        deberiaSer.add(2);

        ListaUtils.sacarMayoresDe(intlist, 2);
        assertTrue(intlist.equals(deberiaSer));
    }

    public void testSacarMenoresDe() {
        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(2);
        deberiaSer.add(3);
        deberiaSer.add(4);
        deberiaSer.add(5);

        ListaUtils.sacarMenoresDe(intlist, 2);
        assertTrue(intlist.equals(deberiaSer));
    }

}
