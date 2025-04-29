package it.prova.gestioneordiniarticolicategorie.service.ordine;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.ordine.OrdineDAO;
import it.prova.gestioneordiniarticolicategorie.exception.ArticoloPresenteInOrdineException;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class OrdineServiceImpl implements OrdineService{

    private OrdineDAO ordineDAO;

    @Override
    public void aggiungiOrdine(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            if(ordineInstance == null){
                throw new Exception("Problema valore in input");
            }
            entityManager.getTransaction().begin();

            ordineDAO.setEntityManager(entityManager);

            ordineDAO.insert(ordineInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }

    }

    @Override
    public void rimuoviOrdine(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Ordine ordine = trovaByIdEager(id);

            if(!ordine.getArticoli().isEmpty()){
                throw new ArticoloPresenteInOrdineException();
            }

            ordineDAO.setEntityManager(entityManager);
            Ordine ordineInstance = ordineDAO.get(id);
            ordineDAO.delete(ordineInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void aggiornaOrdine(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            if (ordineInstance == null || ordineInstance.getId() < 1) {
                throw new Exception("Id invalido");
            }
            entityManager.getTransaction().begin();

            ordineDAO.setEntityManager(entityManager);
            ordineDAO.update(ordineInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Ordine trovaById(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            if (id == null || id < 1) {
                throw new Exception("Id invalido");
            }
            entityManager.getTransaction().begin();

            ordineDAO.setEntityManager(entityManager);
            Ordine ordine = ordineDAO.get(id);

            entityManager.getTransaction().commit();
            return ordine;

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void setOrdineDAO(OrdineDAO ordineDAOInstance) {
        this.ordineDAO = ordineDAOInstance;
    }

    @Override
    public Ordine trovaByIdEager(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if(id == null){
                throw new Exception("Problema valore in input");
            }
            ordineDAO.setEntityManager(entityManager);
            return ordineDAO.findByIdEager(id);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Ordine trovaPiuRecenteByCategoria(Long idCategoria) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if (idCategoria == null) {
                throw new Exception("Problema valore in input");
            }
            ordineDAO.setEntityManager(entityManager);
            return ordineDAO.findPiuRecenteByCategoria(idCategoria);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean trovaByNomeDestinatario(String nomeDestinatario) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if (nomeDestinatario == null) {
                throw new Exception("Problema valore in input");
            }
            ordineDAO.setEntityManager(entityManager);
            return ordineDAO.findByNomeDestinatario(nomeDestinatario);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Ordine> trovaOrdiniDistintiByStringaInNumeroSeriale(String stringa) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if(stringa == null) {
                throw new Exception("Problema valore in input");
            }
            ordineDAO.setEntityManager(entityManager);
            return ordineDAO.findDistinctByStringInNumeroSeriale(stringa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            entityManager.close();
        }
    }
}
