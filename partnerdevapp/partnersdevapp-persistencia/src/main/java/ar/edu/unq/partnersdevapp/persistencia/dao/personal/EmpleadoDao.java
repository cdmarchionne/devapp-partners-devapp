package ar.edu.unq.partnersdevapp.persistencia.dao.personal;

import ar.edu.unq.partnersdevapp.dominio.personal.Empleado;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 *
 */
public class EmpleadoDao extends HibernateGenericDao<Empleado> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Empleado> getDomainClass() {
        return Empleado.class;
    }

}
