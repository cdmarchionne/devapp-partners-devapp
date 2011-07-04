package ar.edu.unq.partnersdevapp.persistencia.dao.carrera;

import java.util.List;

import org.hibernate.Query;

import ar.edu.unq.partnersdevapp.dominio.carrera.Nivel;
import ar.edu.unq.partnersdevapp.persistencia.dao.HibernateGenericDao;

/**
 * Acceso a Datos de Nivel
 * 
 * @param <T>
 */
public class NivelDao extends HibernateGenericDao<Nivel> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Class<Nivel> getDomainClass() {
        return Nivel.class;
    }

    @SuppressWarnings("unchecked")
    public List<Nivel> findByIdPlan_Id(final int id) {
        // ??? no puede con criterira por que no reconoce a plan_id por no ser
        // atributo de Nivel

        String hql = "from Nivel where plan_id = :id ";

        Query query = this.getSession().createQuery(hql);
        query.setInteger("id", id);

        return query.list();

    }
}
