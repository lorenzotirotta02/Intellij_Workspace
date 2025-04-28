package it.prova.gestionesmartphoneapp.service;

import it.prova.gestionesmartphoneapp.dao.EntityManagerUtil;
import it.prova.gestionesmartphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.gestionesmartphoneapp.model.Smartphone;

import javax.persistence.EntityManager;

public class SmartphoneServiceImpl implements SmartphoneService{

    private SmartphoneDAO smartphoneDAO;

    @Override
    public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
        this.smartphoneDAO = smartphoneDAO;
    }

    @Override
    public void aggiungiSmartphone(Smartphone smartphoneInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();

            entityManager.persist(smartphoneInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void AggiornaVersioneOs(Long id, String versione) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Smartphone smartphone = entityManager.find(Smartphone.class, id);

            if (smartphone != null) {
                smartphone.setVersioneOs(versione);
                entityManager.merge(smartphone);
            } else {
                throw new Exception("Smartphone non trovato");
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
