package ar.edu.unq.partnersdevapp.test.planDeCarrera;

import junit.framework.TestCase;
import ar.edu.unq.partnersdevapp.dominio.baseDeDatos.BaseNiveles;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.carrera.Posicion;

public class PlanCarreraTest extends TestCase {

    public void testSubirNivel() {
        PlanDeCarrera plan = new PlanDeCarrera("tester", "desc");
        plan.addNivel(BaseNiveles.getNivelJunior());
        plan.addNivel(BaseNiveles.getNivelSenior());
        plan.addNivel(BaseNiveles.getNivelSemiSenior());

        Posicion oldPosicion = new Posicion("junior", 50);
        Posicion newPosicion = new Posicion("junior", 100);

        assertTrue(plan.getNivelSuperior(oldPosicion).equals(newPosicion));

        oldPosicion = new Posicion("senior", 33);
        newPosicion = new Posicion("senior", 66);

        assertTrue(plan.getNivelSuperior(oldPosicion).equals(newPosicion));

        oldPosicion = new Posicion("junior", 33);
        newPosicion = new Posicion("senior", 66);

        assertFalse(plan.getNivelSuperior(oldPosicion).equals(newPosicion));

        oldPosicion = new Posicion("junior", 100);
        newPosicion = new Posicion("semiSenior", 0);

        System.out.println(plan.getNiveles());
        assertTrue(plan.getNivelSuperior(oldPosicion).equals(newPosicion));
    }
}
