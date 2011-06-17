package ar.edu.unq.partnersdevapp.dominio.basededatos;

import ar.edu.unq.partnersdevapp.dominio.carrera.Banda;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * Para simular una entrada por base de datos. Podria ser una clase intermedia
 * que le pida ciertas cosas a la base XXX simular base de datos en model ?? eso
 * no deberia pasar jamas :)
 */

public class BaseDeDatosHelper {

    private BaseDeDatosHelper() {
        throw new UnsupportedOperationException();
    }

    // *****************************************
    // ******* niveles predeterminados Standars
    public static Nivel getNivelJunior() {
        return new Nivel("junior", new Banda(3), 2000, 1000);
    }

    public static Nivel getNivelSemiSenior() {
        return new Nivel("semiSenior", new Banda(3), 4000, 2000);
    }

    public static Nivel getNivelSenior() {
        return new Nivel("senior", new Banda(4), 5500, 4000);
    }

    public static Nivel getNiveLlider() {
        return new Nivel("lider", new Banda(5), 8000, 5500);
    }

    // ******************************************
    // ******* Plan de carrera Standar

    public static PlanDeCarrera getPlanDeCarreraStandartTester() throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tester", "Esto es un plan de tester");
        plan.addNivelAnterior(BaseDeDatosHelper.getNivelJunior(), null);
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), BaseDeDatosHelper.getNivelJunior());
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), BaseDeDatosHelper.getNivelSemiSenior());
        plan.addNivelPosterior(BaseDeDatosHelper.getNiveLlider(), BaseDeDatosHelper.getNivelSenior());

        return plan;
    }

    // ***********************************************
    // ******** Licencias
    public static LicenciaTipo getLicenciaVacaciones() {
        return new LicenciaTipo("vacaciones", true, -1, -1);
    }

    public static LicenciaTipo getEnfermedad() {
        return new LicenciaTipo("enfermedad", true, -1, -1);
    }

    public static LicenciaTipo getEstudio() {
        return new LicenciaTipo("estudio", true, 2, 12);
    }

    public static LicenciaTipo getMudanza() {
        return new LicenciaTipo("mudanza", true, 2, 5);
    }
}
