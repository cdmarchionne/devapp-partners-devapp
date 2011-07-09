package ar.edu.unq.partnersdevapp.persistencia.dao;

import java.io.Serializable;
import java.util.List;

/** Operaciones elementales de persistencia */

public interface GenericDao<T> extends Serializable {

    void save(T entity);

    void delete(T entity);

    void update(T entity);

    T findById(Serializable id);// NOPMD

    List<T> findAll();

    void deleteById(Serializable id);// NOPMD
}