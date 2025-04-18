package it.prova.proprietarioautomobile.service.proprietario;

import it.prova.proprietarioautomobile.dao.EntityManagerUtil;
import it.prova.proprietarioautomobile.dao.proprietario.ProprietarioDAO;
import it.prova.proprietarioautomobile.model.Proprietario;

import javax.persistence.EntityManager;
import java.util.List;

public class ProprietarioServiceImpl implements ProprietarioService{

    private ProprietarioDAO proprietarioDAO;

    @Override
    public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
        this.proprietarioDAO = proprietarioDAO;
    }

    @Override
    public List<Proprietario> listAllProprietari() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            return proprietarioDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void inserisciNuovo(Proprietario proprietario) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            proprietarioDAO.insert(proprietario);
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
    public void aggiorna(Proprietario proprietario) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            proprietarioDAO.update(proprietario);
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
    public void rimuovi(Long idProprietario) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            Proprietario proprietarioInstance = proprietarioDAO.get(idProprietario);
            proprietarioDAO.delete(proprietarioInstance);
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
    public Proprietario caricaSingoloProprietario(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            proprietarioDAO.setEntityManager(entityManager);
            return proprietarioDAO.get(id);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }
}
