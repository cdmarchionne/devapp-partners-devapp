package ar.edu.unq.partnersdevapp.persistencia.dao.carrera;

import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 * Acceso a Datos de Nivel
 */
public class NivelDao extends HibernateGenericDao<Nivel> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Nivel> getDomainClass() {
        return Nivel.class;
    }

}
