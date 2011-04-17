package ar.edu.unq.partnersdevapp.test.planDeCarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Tecnologia;

/**
 * TODO: description
 */
public class TecnologiaTest extends TestCase {

    private static final String JAVA = "JAVA";

    private static final String POO = "POO";

    private static final String MYSQL = "Mysql";

    private static final String WICKET = "Wicket";

    private static final String HIBERNATE = "Hibernate";

    private static final String POSTGRE_SQL = "PostgreSQL";

    private static final String TECNOLOGIA_BORRADOR = "TecnologiaBorrador";

    @Override
    protected void setUp() throws Exception {
        Tecnologia.addTecnologia(JAVA);
        Tecnologia.addTecnologia(POO);
        Tecnologia.addTecnologia(MYSQL);
        Tecnologia.addTecnologia(WICKET);
        Tecnologia.addTecnologia(HIBERNATE);
        Tecnologia.addTecnologia(POSTGRE_SQL);
    }

    @Override
    protected void tearDown() throws Exception {
        Tecnologia.removeTecnologia(JAVA);
        Tecnologia.removeTecnologia(POO);
        Tecnologia.removeTecnologia(MYSQL);
        Tecnologia.removeTecnologia(WICKET);
        Tecnologia.removeTecnologia(HIBERNATE);
        Tecnologia.removeTecnologia(POSTGRE_SQL);
    }

    public void testAgregarTecnologia() {
        assertTrue(Tecnologia.existeTecnologia(JAVA));
        assertTrue(Tecnologia.existeTecnologia(POO));
        assertTrue(Tecnologia.existeTecnologia(MYSQL));
        assertTrue(Tecnologia.existeTecnologia(WICKET));
        assertTrue(Tecnologia.existeTecnologia(HIBERNATE));
        assertTrue(Tecnologia.existeTecnologia(POSTGRE_SQL));
    }

    public void testBorrarTecnologia() {
        Tecnologia.addTecnologia(TECNOLOGIA_BORRADOR);
        assertTrue(Tecnologia.existeTecnologia(TECNOLOGIA_BORRADOR));

        Tecnologia.removeTecnologia(TECNOLOGIA_BORRADOR);
        assertFalse(Tecnologia.existeTecnologia(TECNOLOGIA_BORRADOR));
    }

    public void testTecnologia() {
        Tecnologia tecnologiaDePrueba = new Tecnologia(JAVA);
        assertEquals(JAVA, tecnologiaDePrueba.getTecnologiaActual());
    }

}
