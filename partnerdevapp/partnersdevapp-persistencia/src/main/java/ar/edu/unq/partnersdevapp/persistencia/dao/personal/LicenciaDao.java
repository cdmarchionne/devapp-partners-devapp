package ar.edu.unq.partnersdevapp.persistencia.dao.personal;

import ar.edu.unq.partnersdevapp.dominio.licencia.LicenciaTipo;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 * TODO: description
 * 
 * @param <T>
 */
public class LicenciaDao extends HibernateGenericDao<LicenciaTipo> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<LicenciaTipo> getDomainClass() {
        return LicenciaTipo.class;
    }

}
