package it.prova.gestionesmartphoneapp.dao.app;

import it.prova.gestionesmartphoneapp.model.App;

import javax.persistence.EntityManager;
import java.util.List;

public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;


    @Override
    public List<App> list() throws Exception {
        return List.of();
    }

    @Override
    public App get(Long id) throws Exception {
        return entityManager.find(App.class, id);
    }

    @Override
    public void update(App o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(App o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(App o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
