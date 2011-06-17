package ar.edu.unq.partnersdevapp.test.plandecarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

public class PlanCarreraTest extends TestCase {
    private static final Nivel JUNIOR = BaseDeDatosHelper.getNivelJunior();

    private static final Nivel SENIOR = BaseDeDatosHelper.getNivelSenior();

    private static final Nivel SEMISENIOR = BaseDeDatosHelper.getNivelSemiSenior();

    private static final Nivel LIDER = BaseDeDatosHelper.getNiveLlider();

    public void testAgregarUnNivelPosterior() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), null);
        assertEquals("", plan.getJerarquiaDeNivel(SEMISENIOR), 0);

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), SEMISENIOR);
        assertEquals("", plan.getJerarquiaDeNivel(SEMISENIOR), 0);
        assertEquals("", plan.getJerarquiaDeNivel(SENIOR), 1);

        plan.addNivelPosterior(new Nivel("xxx", null, 0, 0), SEMISENIOR);
        assertEquals("", plan.getJerarquiaDeNivel(SEMISENIOR), 0);
        assertEquals("", plan.getJerarquiaDeNivel(SENIOR), 2);

    }

    public void testAgregarUnNivelAnterior() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelAnterior(BaseDeDatosHelper.getNivelSenior(), null);
        assertEquals("", plan.getJerarquiaDeNivel(SENIOR), 0);

        plan.addNivelAnterior(BaseDeDatosHelper.getNivelSemiSenior(), SENIOR);
        assertEquals("", plan.getJerarquiaDeNivel(SEMISENIOR), 0);
        assertEquals("", plan.getJerarquiaDeNivel(SENIOR), 1);

        plan.addNivelAnterior(new Nivel("xxx", null, 0, 0), SENIOR);
        assertEquals("", plan.getJerarquiaDeNivel(SEMISENIOR), 0);
        assertEquals("", plan.getJerarquiaDeNivel(SENIOR), 2);

    }

    public void testSubirNivel() throws NoHayResultadoException {

        PlanDeCarrera plan = BaseDeDatosHelper.getPlanDeCarreraStandartTester();

        Posicion oldPosicion = new Posicion(JUNIOR, 50);
        Posicion newPosicion = new Posicion(JUNIOR, 100);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(SENIOR, 33);
        newPosicion = new Posicion(SENIOR, 66);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(JUNIOR, 100);
        newPosicion = new Posicion(SEMISENIOR, 0);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(SEMISENIOR, 100);
        newPosicion = new Posicion(SENIOR, 0);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(SENIOR, 100);
        newPosicion = new Posicion(LIDER, 0);
        assertTrue("", plan.getPosicionSuperior(oldPosicion).isIgual(newPosicion));

        oldPosicion = new Posicion(LIDER, 100);

        try {
            newPosicion = plan.getPosicionSuperior(oldPosicion);
        } catch (Exception e) {
            assertTrue("", e.getClass().equals(NoHayResultadoException.class));
        } finally {
            System.out.println(newPosicion);
            assertTrue("", newPosicion.isIgual(new Posicion(LIDER, 100)));
        }

    }
}
