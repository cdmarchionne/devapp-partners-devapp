package ar.edu.unq.partnersdevapp.persistencia.dao.personal;

import ar.edu.unq.partnersdevapp.dominio.personal.Cliente;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 *
 */
public class ClienteDao extends HibernateGenericDao<Cliente> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Cliente> getDomainClass() {
        return Cliente.class;
    }

}
