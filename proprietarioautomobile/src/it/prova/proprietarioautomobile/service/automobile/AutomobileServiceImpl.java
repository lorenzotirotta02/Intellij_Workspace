package it.prova.proprietarioautomobile.service.automobile;

import it.prova.proprietarioautomobile.dao.EntityManagerUtil;
import it.prova.proprietarioautomobile.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobile.model.Automobile;

import javax.persistence.EntityManager;
import java.util.List;

public class AutomobileServiceImpl implements AutomobileService{
    // Implementazione dei metodi dell'interfaccia AutomobileService

    private AutomobileDAO automobileDAO;

    public void setAutomobileDAO(AutomobileDAO automobileDAO) {
        this.automobileDAO = automobileDAO;
    }


    @Override
    public List<Automobile> listAllAutomobili() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            // uso l'injection per il dao
            automobileDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return automobileDAO.list();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void aggiorna(Automobile automobileInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            // uso l'injection per il dao
            automobileDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            automobileDAO.update(automobileInstance);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

    }

    @Override
    public void inserisciNuovo(Automobile automobileInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            // uso l'injection per il dao
            automobileDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            automobileDAO.insert(automobileInstance);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

    }

    @Override
    public void rimuovi(Long idAutomobileInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            // uso l'injection per il dao
            automobileDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            automobileDAO.delete(automobileDAO.get(idAutomobileInstance));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

    }

    @Override
    public Automobile caricaSingoloAutomobile(Long idAutomobileInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            // uso l'injection per il dao
            automobileDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return automobileDAO.get(idAutomobileInstance);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }



}
