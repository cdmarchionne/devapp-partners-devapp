package ar.edu.unq.partnersdevapp.persistencia;

import org.hibernate.Session;

import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * TODO: description
 */
public class PlanPrueba {

    private static final String JUNIOR = "junior";

    private static final String SENIOR = "senior";

    private static final String SEMISENIOR = "semiSenior";

    public static void main(final String[] args) throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), null);
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), SEMISENIOR);
        plan.addNivelPosterior(new Nivel("xxx", null, 0, 0), SEMISENIOR);

        Session sesion = HibernateUtils.getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        sesion.save(plan);
        sesion.getTransaction().commit();
        HibernateUtils.getSessionFactory().close();

    }
}
