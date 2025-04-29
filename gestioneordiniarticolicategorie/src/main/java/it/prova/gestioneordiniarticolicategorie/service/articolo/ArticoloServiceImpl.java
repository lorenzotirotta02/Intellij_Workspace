package it.prova.gestioneordiniarticolicategorie.service.articolo;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public class ArticoloServiceImpl implements ArticoloService{

    private ArticoloDAO articoloDao;

    @Override
    public Articolo trovaArticolo(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (id == null || id < 1) {
                throw new Exception("Id invalido");
            }
            articoloDao.setEntityManager(entityManager);
            return articoloDao.get(id);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiornaArticolo(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            if(articoloInstance == null || articoloInstance.getId() < 1) {
                throw new Exception("Id invalido");
            }
            entityManager.getTransaction().begin();

            articoloDao.setEntityManager(entityManager);
            articoloDao.update(articoloInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiungiArticolo(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            if (articoloInstance == null) {
                throw new Exception("Problema valore in input");
            }
            entityManager.getTransaction().begin();

            articoloDao.setEntityManager(entityManager);
            articoloDao.insert(articoloInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void rimuoviArticolo(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            if (id == null || id < 1) {
                throw new Exception("Id invalido");
            }
            entityManager.getTransaction().begin();

            articoloDao.setEntityManager(entityManager);
            Articolo articolo = articoloDao.get(id);
            articoloDao.delete(articolo);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void setArticoloDao(ArticoloDAO articoloDAOInstance) {
        this.articoloDao = articoloDAOInstance;
    }
}
