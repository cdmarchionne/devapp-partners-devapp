package ar.edu.unq.partnersdevapp.persistencia.dao.carrera;

import ar.edu.unq.partnersdevapp.dominio.carrera.PlanDeCarrera;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 * XXX falta hacer todos los accesosrs a la persistencia
 */
public class PlanDao extends HibernateGenericDao<PlanDeCarrera> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<PlanDeCarrera> getDomainClass() {
        return PlanDeCarrera.class;
    }

}
