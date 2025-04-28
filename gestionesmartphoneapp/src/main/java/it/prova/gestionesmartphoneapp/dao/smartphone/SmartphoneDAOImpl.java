package it.prova.gestionesmartphoneapp.dao.smartphone;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO{

    private EntityManager entityManager;

    @Override
    public List<Smartphone> list() throws Exception {
        return List.of();
    }

    public Smartphone findByIdFetchingApps(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            TypedQuery<Smartphone> query = entityManager.createQuery(
                    "select s from Smartphone s left join fetch s.apps where s.id = :id", Smartphone.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public Smartphone get(Long id) throws Exception {
        if(id == null){
            throw new Exception("Problema valore in input");
        }
        return entityManager.find(Smartphone.class, id);
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
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Smartphone o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addApp(Smartphone smartphoneInstance) throws Exception {
        if (smartphoneInstance == null) {
            throw new Exception("Problema valore in input");
        }
        smartphoneInstance = entityManager.merge(smartphoneInstance);
    }
    @Override
    public void removeAppFromSmartphone(Long idApp) throws Exception {
        if (idApp == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.createNativeQuery("DELETE FROM smartphone_app WHERE app_id = :idApp")
                .setParameter("idApp", idApp)
                .executeUpdate();
    }

    @Override
    public Smartphone findByIdFetchApps(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Problema valore in input");
        }
        return entityManager.createQuery("select s from Smartphone s left join fetch s.apps where s.id = :id", Smartphone.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
