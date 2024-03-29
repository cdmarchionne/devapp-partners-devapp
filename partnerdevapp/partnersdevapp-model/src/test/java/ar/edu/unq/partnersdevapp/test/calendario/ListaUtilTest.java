package ar.edu.unq.partnersdevapp.test.calendario;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.utils.ListaUtils;

/**
 * Test de FechaUtils
 */
public class ListaUtilTest extends TestCase {
    private List<Integer> intlist = new ArrayList<Integer>();

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

        assertEquals("", intlist, deberiaSer);
    }

    public void testSacarMenoresDe() {
        List<Integer> deberiaSer = new ArrayList<Integer>();
        deberiaSer.add(2);
        deberiaSer.add(3);
        deberiaSer.add(4);
        deberiaSer.add(5);

        ListaUtils.sacarMenoresDe(intlist, 2);
        assertEquals("", intlist, deberiaSer);
    }

    public List<Integer> getIntlist() {
        return intlist;
    }

    public void setIntlist(final List<Integer> intlist) {
        this.intlist = intlist;
    }

}
