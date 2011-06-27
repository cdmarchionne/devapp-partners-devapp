package ar.edu.unq.partnersdevapp.persistencia.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Operaciones basicas de persistencia.
 */
public abstract class HibernateGenericDao<T> extends HibernateDaoSupport implements GenericDao<T> {
    private static final long serialVersionUID = 1L;

    protected Class<T> persistentClass = this.getDomainClass();

    protected abstract Class<T> getDomainClass();

    @Override
    public void save(final T entity) {
        this.getHibernateTemplate().save(entity);
        this.getHibernateTemplate().flush();
    }

    @Override
    public void delete(final T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(final T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(final Serializable id) {
        return (T) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public T doInHibernate(final Session session) throws HibernateException, SQLException {
                Criteria idCriteria = session.createCriteria(HibernateGenericDao.this.getDomainClass());
                idCriteria.add(Restrictions.idEq(id));
                return (T) idCriteria.uniqueResult();
            }
        });

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<T> doInHibernate(final Session session) throws HibernateException, SQLException {
                Criteria listCriteria = session.createCriteria(HibernateGenericDao.this.getDomainClass());
                return listCriteria.list();
            }
        });
    }

    @Override
    public void deleteById(final Serializable id) {
        this.getHibernateTemplate().delete(this.findById(id));
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
}