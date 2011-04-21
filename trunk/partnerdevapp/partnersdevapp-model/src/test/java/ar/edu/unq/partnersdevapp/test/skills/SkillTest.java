package ar.edu.unq.partnersdevapp.test.skills;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Categoria;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.carrera.Tecnologia;

/**
 * TODO: description
 */
public class SkillTest extends TestCase {

    private static final String AGREGO_EL_CONOCIMIENTO = "Agrego el conocimiento ";

    private static final String DE = " de ";

    private static final String JAVA = "JAVA";

    private static final String POO = "POO";

    private static final String MYSQL = "Mysql";

    private static final String WICKET = "Wicket";

    private static final String HIBERNATE = "Hibernate";

    private static final String POSTGRE_SQL = "PostgreSQL";

    private static final String BASICO = "Basico";

    private static final String MEDIO = "Medio";

    private static final String EXPERTO = "Experto";

    @Override
    protected void setUp() throws Exception {
        Tecnologia.addTecnologia(JAVA);
        Tecnologia.addTecnologia(POO);
        Tecnologia.addTecnologia(MYSQL);
        Tecnologia.addTecnologia(WICKET);
        Tecnologia.addTecnologia(HIBERNATE);
        Tecnologia.addTecnologia(POSTGRE_SQL);

        Categoria.addCategoria(0, BASICO);
        Categoria.addCategoria(1, MEDIO);
        Categoria.addCategoria(2, EXPERTO);
    }

    @Override
    protected void tearDown() throws Exception {
        Tecnologia.removeTecnologia(JAVA);
        Tecnologia.removeTecnologia(POO);
        Tecnologia.removeTecnologia(MYSQL);
        Tecnologia.removeTecnologia(WICKET);
        Tecnologia.removeTecnologia(HIBERNATE);
        Tecnologia.removeTecnologia(POSTGRE_SQL);

        Categoria.removeCategoria(BASICO);
        Categoria.removeCategoria(MEDIO);
        Categoria.removeCategoria(EXPERTO);
    }

    public void testAgregarSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        message = AGREGO_EL_CONOCIMIENTO + BASICO + DE + JAVA;
        assertEquals(message, BASICO, conocimientos.getCategoriaNombre(JAVA));

        conocimientos.addSkill(POO, MEDIO);
        message = AGREGO_EL_CONOCIMIENTO + MEDIO + DE + POO;
        assertEquals(message, MEDIO, conocimientos.getCategoriaNombre(POO));
    }

    public void testSubirSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        message = AGREGO_EL_CONOCIMIENTO + BASICO + DE + JAVA;
        assertEquals(message, BASICO, conocimientos.getCategoriaNombre(JAVA));

        conocimientos.subirCategoria(JAVA);
        message = "Subi el conocimiento de " + JAVA;
        assertNotSame(message, BASICO, conocimientos.getCategoriaNombre(JAVA));
        message = "El conocimiento de " + JAVA + " es " + MEDIO;
        assertEquals(message, MEDIO, conocimientos.getCategoriaNombre(JAVA));
    }

    public void testBajarSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(POO, MEDIO);
        message = AGREGO_EL_CONOCIMIENTO + MEDIO + DE + POO;
        assertEquals(message, MEDIO, conocimientos.getCategoriaNombre(POO));

        conocimientos.bajarCategoria(POO);
        message = "Bajo el conocimiento de " + POO;
        assertNotSame(message, MEDIO, conocimientos.getCategoriaNombre(POO));
        message = "El conocimiento de " + POO + " es " + BASICO;
        assertEquals(message, BASICO, conocimientos.getCategoriaNombre(POO));
    }

    public void testCumpleMismasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(POO, MEDIO);
        requisitos.addSkill(POO, MEDIO);
        message = "Los requisitos de conocimiento son: " + POO + ", " + MEDIO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));

        conocimientos.bajarCategoria(POO);
        message = "Bajo los conocimiento de " + POO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.bajarCategoria(POO);
        message = "Bajo los requisitos de " + POO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }

    public void testNoCumpleMismasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(POO, BASICO);
        requisitos.addSkill(POO, MEDIO);
        message = "Los requisitos de conocimiento son: " + POO + ", " + MEDIO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.subirCategoria(POO);
        message = "Subo los requisitos de " + POO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.bajarCategoria(POO);
        conocimientos.subirCategoria(POO);
        message = "Bajo los requisitos de " + POO + " y Subo los conocimientos " + POO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }

    public void testCumpleDistintasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        conocimientos.addSkill(POO, MEDIO);
        conocimientos.addSkill(HIBERNATE, EXPERTO);

        requisitos.addSkill(JAVA, BASICO);
        requisitos.addSkill(POO, MEDIO);
        requisitos.addSkill(HIBERNATE, EXPERTO);

        message = "Los requisitos de conocimiento son Varios";
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.subirCategoria(POO);
        message = "Subo los requisitos";
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));
    }

    public void testNoCumpleDistintasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        conocimientos.addSkill(POO, MEDIO);
        conocimientos.addSkill(HIBERNATE, EXPERTO);

        requisitos.addSkill(JAVA, EXPERTO);
        requisitos.addSkill(POO, EXPERTO);
        requisitos.addSkill(HIBERNATE, EXPERTO);

        message = "Los requisitos de conocimiento son Exigentes";
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        conocimientos.subirCategoria(JAVA);
        conocimientos.subirCategoria(JAVA);
        conocimientos.subirCategoria(POO);
        message = "Subo los conocimientos para alcanzarlos";
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }
}
