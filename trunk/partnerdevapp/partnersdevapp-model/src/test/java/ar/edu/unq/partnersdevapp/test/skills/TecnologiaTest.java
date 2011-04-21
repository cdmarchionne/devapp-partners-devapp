package ar.edu.unq.partnersdevapp.test.skills;

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
        String message = "Agrego una Tecnologia";

        assertTrue(message + JAVA, Tecnologia.existeTecnologia(JAVA));
        assertTrue(message + POO, Tecnologia.existeTecnologia(POO));
        assertTrue(message + MYSQL, Tecnologia.existeTecnologia(MYSQL));
        assertTrue(message + WICKET, Tecnologia.existeTecnologia(WICKET));
        assertTrue(message + HIBERNATE, Tecnologia.existeTecnologia(HIBERNATE));
        assertTrue(message + POSTGRE_SQL, Tecnologia.existeTecnologia(POSTGRE_SQL));
    }

    public void testBorrarTecnologia() {
        String message;

        message = "Agrego una Tecnologia cualquiera";
        Tecnologia.addTecnologia(TECNOLOGIA_BORRADOR);
        assertTrue(message, Tecnologia.existeTecnologia(TECNOLOGIA_BORRADOR));

        message = "Borro esa Tecnologia";
        Tecnologia.removeTecnologia(TECNOLOGIA_BORRADOR);
        assertFalse(message, Tecnologia.existeTecnologia(TECNOLOGIA_BORRADOR));
    }

    public void testTecnologia() {
        Tecnologia tecnologiaDePrueba = new Tecnologia(JAVA);

        String message = "Creo una Tecnologia " + JAVA;
        assertEquals(message, JAVA, tecnologiaDePrueba.getTecnologiaActual());
    }

}
