package ar.edu.unq.partnersdevapp;

import org.hibernate.Session;

import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

/**
 * XXX los test deben tener el nombre "Test" , ademas es un test que tiene un
 * main ??
 */
public class PruebaDb {

    public static void main(final String[] args) throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), null);
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), BaseDeDatosHelper.getNivelSemiSenior());
        plan.addNivelPosterior(new Nivel("xxx", null, 0, 0), BaseDeDatosHelper.getNivelSemiSenior());

        Session sesion = HibernateUtils.getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        sesion.save(plan);
        // sesion.save(banda);
        sesion.getTransaction().commit();
    }

}
