package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

import javax.persistence.EntityManager;

public class AppServiceImpl implements AppService{

    private AppDAO appDAO;

    @Override
    public void aggiungiApp(App appInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{

            entityManager.getTransaction().begin();

            entityManager.persist(appInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void setAppDAO(AppDAO appDAOInstance) {
        this.appDAO = appDAOInstance;
    }



}
