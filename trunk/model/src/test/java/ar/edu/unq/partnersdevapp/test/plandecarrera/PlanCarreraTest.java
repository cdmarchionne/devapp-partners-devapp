package ar.edu.unq.partnersdevapp.test.plandecarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseNiveles;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;

public class PlanCarreraTest extends TestCase {
    private static final String JUNIOR = "junior";

    private static final String SENIOR = "senior";

    private static final String SEMISENIOR = "semiSenior";

    public void testSubirNivel() {
        PlanDeCarrera plan = new PlanDeCarrera("tester", "desc");
        plan.addNivel(BaseNiveles.getNivelJunior());
        plan.addNivel(BaseNiveles.getNivelSenior());
        plan.addNivel(BaseNiveles.getNivelSemiSenior());

        Posicion oldPosicion = new Posicion(JUNIOR, 50);
        Posicion newPosicion = new Posicion(JUNIOR, 100);

        assertEquals("", plan.getNivelSuperior(oldPosicion), newPosicion);

        oldPosicion = new Posicion(SENIOR, 33);
        newPosicion = new Posicion(SENIOR, 66);

        assertEquals("", plan.getNivelSuperior(oldPosicion), newPosicion);

        oldPosicion = new Posicion(JUNIOR, 33);
        newPosicion = new Posicion(SENIOR, 66);

        assertNotSame("", plan.getNivelSuperior(oldPosicion), newPosicion);

        oldPosicion = new Posicion(JUNIOR, 100);
        newPosicion = new Posicion(SEMISENIOR, 0);

        assertEquals("", plan.getNivelSuperior(oldPosicion), newPosicion);

    }
}
