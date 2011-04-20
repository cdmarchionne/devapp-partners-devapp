package ar.edu.unq.partnersdevapp.test.skills;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.carrera.Categoria;
import ar.edu.unq.partnersdevapp.dominio.carrera.Skills;
import ar.edu.unq.partnersdevapp.dominio.carrera.Tecnologia;

/**
 * TODO: description
 */
public class SkillTest extends TestCase {

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

        conocimientos.addSkill(JAVA, BASICO);
        conocimientos.addSkill(POO, MEDIO);
        assertEquals(BASICO, conocimientos.getCategoria(JAVA));
        assertEquals(MEDIO, conocimientos.getCategoria(POO));
    }

    public void testSubirSkill() {
        Skills conocimientos = new Skills();

        conocimientos.addSkill(JAVA, BASICO);
        assertEquals(BASICO, conocimientos.getCategoria(JAVA));

        conocimientos.subirCategoria(JAVA);
        assertFalse(BASICO == conocimientos.getCategoria(JAVA));
        assertEquals(MEDIO, conocimientos.getCategoria(JAVA));
    }

    public void testBajarSkill() {
        Skills conocimientos = new Skills();

        conocimientos.addSkill(POO, MEDIO);
        assertEquals(MEDIO, conocimientos.getCategoria(POO));

        conocimientos.bajarCategoria(POO);
        assertFalse(MEDIO == conocimientos.getCategoria(POO));
        assertEquals(BASICO, conocimientos.getCategoria(POO));
    }
}
