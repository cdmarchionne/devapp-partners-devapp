package ar.edu.unq.partnersdevapp;

import org.hibernate.Session;

import ar.edu.unq.partnersdevapp.dominio.basededatos.BaseDeDatosHelper;
import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.exceptions.NoHayResultadoException;

public class PlanPrueba {

    public void main(final String[] args) throws NoHayResultadoException {
        PlanDeCarrera plan = new PlanDeCarrera("tecnico", "cosas de tecnico");

        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSemiSenior(), null);
        plan.addNivelPosterior(BaseDeDatosHelper.getNivelSenior(), "semiSenior");
        plan.addNivelPosterior(new Nivel("xxx", null, 0, 0), "semiSenior");

        Session sesion = HibernateUtils.getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        sesion.save(plan);
        sesion.getTransaction().commit();
        HibernateUtils.getSessionFactory().close();

    }
}
