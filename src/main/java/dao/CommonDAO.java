package dao;


import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;
/**
 * Created by oleg on 23.11.2015.
 */
public interface CommonDAO<T, ID extends Serializable> {

    public void save(T entity);

    public void merge(T entity);

    public void delete(T entity);

    public List<T> findMany(Query query);

    public T findOne(Query query);

    public List findAll(Class clazz);

    public T findByID(Class clazz, int id);
}
