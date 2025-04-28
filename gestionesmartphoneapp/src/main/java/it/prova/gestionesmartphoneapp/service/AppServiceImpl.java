package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.model.App;

import javax.persistence.EntityManager;

public class AppServiceImpl implements AppService{

    private AppDAO appDAO;


    @Override
    public App trovaById(Long id){
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            if (id == null || id < 1){
                System.out.println("Id invalido");
            }
            appDAO.setEntityManager(entityManager);
            App app = appDAO.get(id);
            return app;
        }catch(Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void rimuoviApp(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            if (id == null || id < 1){
                throw new Exception("Id invalido");
            }

            appDAO.setEntityManager(entityManager);

            App app = appDAO.get(id);
            appDAO.delete(app);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiornaVersioneConData(App appIstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();

            if (appIstance == null) {
                throw new Exception("Problema valore in input");
            }

            appDAO.setEntityManager(entityManager);

            appDAO.update(appIstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiungiApp(App appInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{

            entityManager.getTransaction().begin();

            appDAO.setEntityManager(entityManager);

            appDAO.insert(appInstance);

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
