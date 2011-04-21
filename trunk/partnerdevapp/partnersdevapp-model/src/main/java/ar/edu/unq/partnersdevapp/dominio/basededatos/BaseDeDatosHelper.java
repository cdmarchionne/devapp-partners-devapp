package ar.edu.unq.partnersdevapp.dominio.basededatos;

import ar.edu.unq.partnersdevapp.dominio.carrera.Banda;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;

/**
 * Para simular una entrada por base de datos. Podria ser una clase intermedia
 * que le pida ciertas cosas a la base
 */
public class BaseDeDatosHelper {

    private BaseDeDatosHelper() {
        throw new UnsupportedOperationException();
    }

    // *****************************************
    // ******* niveles predeterminados Standars
    public static Nivel getNivelJunior() {
        return new Nivel("junior", new Banda(2), 0, 0);
    }

    public static Nivel getNivelSemiSenior() {
        return new Nivel("semiSenior", new Banda(2), 0, 0);
    }

    public static Nivel getNivelSenior() {
        return new Nivel("senior", new Banda(3), 0, 0);
    }

    public static Nivel getNiveLlider() {
        return new Nivel("lider", new Banda(4), 0, 0);
    }

    // ******************************************
    // ******* Plan de carrera Standar

    public static PlanDeCarrera getPlanDeCarreraStandartTester() {
        PlanDeCarrera plan = new PlanDeCarrera("tester", "Esto es un plan de tester");
        plan.addNivelAnterior(BaseDeDatosHelper.getNivelJunior(), null);
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), "junior");
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), "semiSenior");
        plan.addNivelPosterior(BaseDeDatosHelper.getNiveLlider(), "senior");

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
