package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.app.AppDAO;
import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.App;
import it.prova.gestionesmartphoneapp.model.Smartphone;

import javax.persistence.EntityManager;

public class SmartphoneServiceImpl implements SmartphoneService {

    private SmartphoneDAO smartphoneDAO;
    private AppDAO appDAO;

    @Override
    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
        this.smartphoneDAO = smartphoneDAO;
    }

    @Override
    public void rimuoviSmartphone(Long id) throws Exception{
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            if (id == null || id < 1) {
                throw new Exception("Id invalido");
            }

            smartphoneDAO.setEntityManager(entityManager);

            Smartphone smartphone = smartphoneDAO.get(id);
            smartphoneDAO.delete(smartphone);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiungiSmartphone(Smartphone smartphoneInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (smartphoneInstance == null) {
                throw new Exception("Problema valore in input");
            }
            entityManager.getTransaction().begin();

            smartphoneDAO.setEntityManager(entityManager);

            smartphoneDAO.insert(smartphoneInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiornaVersioneOs(Smartphone smartphone) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            if (smartphone == null) {
                throw new Exception("Problema valore in input");
            }

            smartphoneDAO.setEntityManager(entityManager);


            smartphoneDAO.update(smartphone);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Smartphone trovaById(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            if (id == null) {
                throw new Exception("Problema valore in input");
            }

            smartphoneDAO.setEntityManager(entityManager);

            Smartphone smartphone = smartphoneDAO.get(id);

            if (smartphone != null) {
                System.out.println("Smartphone trovato: " + smartphone);
            } else {
                throw new Exception("Smartphone non trovato");
            }
            return smartphone;

        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiungiApp(Smartphone smartphoneInstance) throws Exception {
        if (smartphoneInstance == null) {
            throw new Exception("Problema valore in input");
        }

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            smartphoneDAO.setEntityManager(entityManager);

            smartphoneDAO.insert(smartphoneInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public void disinstallaApp(Long idApp) throws Exception {
        if (idApp == null || idApp < 1) {
            throw new Exception("Problema valore in input");
        }

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            smartphoneDAO.setEntityManager(entityManager);

            smartphoneDAO.removeAppFromSmartphone(idApp);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public Smartphone trovaSmartphoneConApp(Long idSmartphone) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            smartphoneDAO.setEntityManager(entityManager);

            smartphoneDAO.findByIdFetchApps(idSmartphone);

            return smartphoneDAO.get(idSmartphone);

        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
