package it.prova.gestionesmartphoneapp.dao.smartphone;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.Smartphone;

import javax.persistence.EntityManager;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO{

    private EntityManager entityManager;
    @Override
    public List<Smartphone> list() throws Exception {
        return List.of();
    }

    @Override
    public Smartphone get(Long id) throws Exception {
        return null;
    }

    @Override
    public void update(Smartphone o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);

    }

    @Override
    public void insert(Smartphone o) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();


    }

    @Override
    public void delete(Smartphone o) throws Exception {

    }

    @Override
    public void setEntityManager(EntityManager entityManager) {

    }
}
