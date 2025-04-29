package it.prova.gestioneordiniarticolicategorie.service.articolo;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.articolo.ArticoloDAO;
import it.prova.gestioneordiniarticolicategorie.model.Articolo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public void rimuoviArticoloCollegatoACategoria(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (articoloInstance == null) {
                throw new Exception("Valore in input non valido");
            }
            entityManager.getTransaction().begin();

            articoloDao.setEntityManager(entityManager);
            articoloDao.deleteArticoloLinkedToCategorie(articoloInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public double sommaPrezziArticoliCollegatiACategoria(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            if(id == null){
                throw new RuntimeException("Valore in input non valido");
            }
            articoloDao.setEntityManager(entityManager);

            return articoloDao.sumAllPrezziDiArticoliLinkedToOneCategoria(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();

        }
    }

    @Override
    public double sommaPrezziArticoliConNomeDestinatario(String nomeDestinatario) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if(nomeDestinatario == null){
                throw new RuntimeException("Valore in input non valido");
            }
            articoloDao.setEntityManager(entityManager);

            return articoloDao.sumAllPrezziDiArticoliWithNomeDestinatario(nomeDestinatario);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Articolo> trovaArticoliConDataSpedizioneDopoDataDiScadenza() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            articoloDao.setEntityManager(entityManager);
            return articoloDao.findAllWithDataSpedizioneAfterDataDiScadenza();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

}
