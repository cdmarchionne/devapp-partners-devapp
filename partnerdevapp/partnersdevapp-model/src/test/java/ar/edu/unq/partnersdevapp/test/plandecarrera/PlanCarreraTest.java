package ar.edu.unq.partnersdevapp.test.plandecarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

public class PlanCarreraTest extends TestCase {
    private static final String JUNIOR = "junior";

    private static final String SENIOR = "senior";

    private static final String SEMISENIOR = "semiSenior";

    private static final String LIDER = "lider";

    public void testAgregarUnNivelPosterior() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), null);
        assertEquals("", plan.getNivel(SEMISENIOR).getJerarquia(), 0);

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), SEMISENIOR);
        assertEquals("", plan.getNivel(SEMISENIOR).getJerarquia(), 0);
        assertEquals("", plan.getNivel(SENIOR).getJerarquia(), 1);

        plan.addNivelPosterior(new Nivel("xxx", null, 0, 0), SEMISENIOR);
        assertEquals("", plan.getNivel(SEMISENIOR).getJerarquia(), 0);
        assertEquals("", plan.getNivel(SENIOR).getJerarquia(), 2);

    }

    public void testAgregarUnNivelAnterior() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelAnterior(BaseDeDatosHelper.getNivelSenior(), null);
        assertEquals("", plan.getNivel(SENIOR).getJerarquia(), 0);

        plan.addNivelAnterior(BaseDeDatosHelper.getNivelSemiSenior(), SENIOR);
        assertEquals("", plan.getNivel(SEMISENIOR).getJerarquia(), 0);
        assertEquals("", plan.getNivel(SENIOR).getJerarquia(), 1);

        plan.addNivelAnterior(new Nivel("xxx", null, 0, 0), SENIOR);
        assertEquals("", plan.getNivel(SEMISENIOR).getJerarquia(), 0);
        assertEquals("", plan.getNivel(SENIOR).getJerarquia(), 2);

    }

    public void testSubirNivel() throws NoHayResultadoException {

        PlanDeCarrera plan = BaseDeDatosHelper.getPlanDeCarreraStandartTester();

        Posicion oldPosicion = new Posicion(JUNIOR, 50);
        Posicion newPosicion = new Posicion(JUNIOR, 100);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(SENIOR, 33);
        newPosicion = new Posicion(SENIOR, 66);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(JUNIOR, 33);
        newPosicion = new Posicion(SENIOR, 66);
        assertFalse("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(JUNIOR, 100);
        newPosicion = new Posicion(SEMISENIOR, 0);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(SENIOR, 100);
        newPosicion = new Posicion(LIDER, 0);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(LIDER, 100);
        newPosicion = new Posicion(LIDER, 100);
        try {
            plan.getPosicionSuperior(oldPosicion);
        } catch (Exception e) {
            assertTrue("", e.getClass().equals(NoHayResultadoException.class));
        }

    }
}
