package it.prova.atletasport.dao;

import javax.persistence.EntityManager;
import java.util.List;

public interface IBaseDAO<T> {

    public List<T> list() throws Exception;

    public T get(Long id) throws Exception;

    public void update(T o) throws Exception;

    public void insert(T o) throws Exception;

    public void delete(T o) throws Exception;

    public void setEntityManager(EntityManager entityManager);

}