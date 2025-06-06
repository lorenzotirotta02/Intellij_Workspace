package it.prova.proprietarioautomobile.dao.proprietario;

import it.prova.proprietarioautomobile.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class ProprietarioDAOImpl implements  ProprietarioDAO{

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Proprietario> list() throws Exception {
        return entityManager.createQuery("from Proprietario", Proprietario.class).getResultList();
    }

    @Override
    public Proprietario get(Long id) throws Exception {
        return entityManager.find(Proprietario.class, id);
    }

    @Override
    public void update(Proprietario proprietarioInstance) throws Exception {
        if (proprietarioInstance == null) {
            throw new Exception("Problema valore in input");
        }
        proprietarioInstance = entityManager.merge(proprietarioInstance);
    }

    @Override
    public void insert(Proprietario proprietarioInstance) throws Exception {
        if (proprietarioInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(proprietarioInstance);
    }

    @Override
    public void delete(Proprietario proprietarioInstance) throws Exception {
        if (proprietarioInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(proprietarioInstance));
    }


}
