package ar.edu.unq.partnersdevapp.test.skills;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Experiencia;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.carrera.Tecnologia;

/**
 * Test de Skill
 */
public class SkillTest extends TestCase {

    private static final String AGREGO_EL_CONOCIMIENTO = "Agrego el conocimiento ";

    private static final String DE = " de "; // NOPMD

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

        Experiencia.addExperiencia(0, BASICO);
        Experiencia.addExperiencia(1, MEDIO);
        Experiencia.addExperiencia(2, EXPERTO);
    }

    @Override
    protected void tearDown() throws Exception {
        Tecnologia.removeTecnologia(JAVA);
        Tecnologia.removeTecnologia(POO);
        Tecnologia.removeTecnologia(MYSQL);
        Tecnologia.removeTecnologia(WICKET);
        Tecnologia.removeTecnologia(HIBERNATE);
        Tecnologia.removeTecnologia(POSTGRE_SQL);

        Experiencia.removeExperiencia(BASICO);
        Experiencia.removeExperiencia(MEDIO);
        Experiencia.removeExperiencia(EXPERTO);
    }

    /** Compruebo que se puedan crear Skill personalizados */
    public void testAgregarSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        message = AGREGO_EL_CONOCIMIENTO + BASICO + DE + JAVA;
        assertEquals(message, BASICO, conocimientos.getExperienciaNombre(JAVA));

        conocimientos.addSkill(POO, MEDIO);
        message = AGREGO_EL_CONOCIMIENTO + MEDIO + DE + POO;
        assertEquals(message, MEDIO, conocimientos.getExperienciaNombre(POO));
    }

    /**
     * Compruebo que se pueda Subir la Experiencia de una Tecnologia en los
     * Skill
     */
    public void testSubirSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(JAVA, BASICO);
        message = AGREGO_EL_CONOCIMIENTO + BASICO + DE + JAVA;
        assertEquals(message, BASICO, conocimientos.getExperienciaNombre(JAVA));

        conocimientos.subirExperiencia(JAVA);
        message = "Subi el conocimiento de " + JAVA;
        assertNotSame(message, BASICO, conocimientos.getExperienciaNombre(JAVA));
        message = "El conocimiento de " + JAVA + " es " + MEDIO;
        assertEquals(message, MEDIO, conocimientos.getExperienciaNombre(JAVA));
    }

    /**
     * Compruebo que se pueda Bajar la Experiencia de una Tecnologia en los
     * Skill
     */
    public void testBajarSkill() {
        Skills conocimientos = new Skills();
        String message;

        conocimientos.addSkill(POO, MEDIO);
        message = AGREGO_EL_CONOCIMIENTO + MEDIO + DE + POO;
        assertEquals(message, MEDIO, conocimientos.getExperienciaNombre(POO));

        conocimientos.bajarExperiencia(POO);
        message = "Bajo el conocimiento de " + POO;
        assertNotSame(message, MEDIO, conocimientos.getExperienciaNombre(POO));
        message = "El conocimiento de " + POO + " es " + BASICO;
        assertEquals(message, BASICO, conocimientos.getExperienciaNombre(POO));
    }

    /**
     * Comparo dos Skill con una Tecnologia sola y verifico que un Conocimiento
     * cumpla con un Requisito
     */
    public void testCumpleMismasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(POO, MEDIO);
        requisitos.addSkill(POO, MEDIO);
        message = "Los requisitos de conocimiento son: " + POO + ", " + MEDIO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));

        conocimientos.bajarExperiencia(POO);
        message = "Bajo los conocimiento de " + POO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.bajarExperiencia(POO);
        message = "Bajo los requisitos de " + POO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }

    /**
     * Comparo dos Skill con una Tecnologia sola y verifico que un Conocimiento
     * NO cumpla con un Requisito
     */
    public void testNoCumpleMismasCondiciones() {
        Skills conocimientos = new Skills();
        Skills requisitos = new Skills();
        String message;

        conocimientos.addSkill(POO, BASICO);
        requisitos.addSkill(POO, MEDIO);
        message = "Los requisitos de conocimiento son: " + POO + ", " + MEDIO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.subirExperiencia(POO);
        message = "Subo los requisitos de " + POO;
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));

        requisitos.bajarExperiencia(POO);
        conocimientos.subirExperiencia(POO);
        message = "Bajo los requisitos de " + POO + " y Subo los conocimientos " + POO;
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }

    /**
     * Comparo dos Skill con varias Tecnologias y verifico que un Conocimiento
     * cumpla con un Requisito
     */
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

        requisitos.subirExperiencia(POO);
        message = "Subo los requisitos";
        assertFalse(message, conocimientos.satisfaceRequisito(requisitos));
    }

    /**
     * Comparo dos Skill con varias Tecnologias y verifico que un Conocimiento
     * NO cumpla con un Requisito
     */
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

        conocimientos.subirExperiencia(JAVA);
        conocimientos.subirExperiencia(JAVA);
        conocimientos.subirExperiencia(POO);
        message = "Subo los conocimientos para alcanzarlos";
        assertTrue(message, conocimientos.satisfaceRequisito(requisitos));
    }
}
