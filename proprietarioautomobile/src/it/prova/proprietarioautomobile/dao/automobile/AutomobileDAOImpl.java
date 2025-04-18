package it.prova.proprietarioautomobile.dao.automobile;

import it.prova.proprietarioautomobile.model.Automobile;

import javax.persistence.EntityManager;
import java.util.List;

public class AutomobileDAOImpl implements  AutomobileDAO{

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Automobile> list() throws Exception {
        // dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
        // non la tabella
        return entityManager.createQuery("from Automobile", Automobile.class).getResultList();
    }

    @Override
    public Automobile get(Long id) throws Exception {
        return entityManager.find(Automobile.class, id);
    }
    @Override
    public void update(Automobile automobileInstance) throws Exception {
        if (automobileInstance == null) {
            throw new Exception("Problema valore in input");
        }
        automobileInstance = entityManager.merge(automobileInstance);
    }

    @Override
    public void insert(Automobile automobileInstance) throws Exception {
        if (automobileInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(automobileInstance);
    }

    @Override
    public void delete(Automobile automobileInstance) throws Exception {
        if (automobileInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(automobileInstance));
    }
}
