package it.prova.gestioneordiniarticolicategorie.service.categoria;

import it.prova.gestioneordiniarticolicategorie.dao.EntityManagerUtil;
import it.prova.gestioneordiniarticolicategorie.dao.categoria.CategoriaDAO;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;

public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaDAO categoriaDAO;

    @Override
    public void aggiungiCategoria(Categoria categoriaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (categoriaInstance == null) {
                throw new Exception("Problema valore in input");
            }
            entityManager.getTransaction().begin();

            categoriaDAO.setEntityManager(entityManager);

            categoriaDAO.insert(categoriaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void rimuoviCategoria(Long id) throws Exception {

    }

    @Override
    public void aggiornaCategoria(Categoria categoriaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if(categoriaInstance == null || categoriaInstance.getId() < 1) {
                throw new Exception("Id invalido");
            }
            entityManager.getTransaction().begin();

            categoriaDAO.setEntityManager(entityManager);
            categoriaDAO.update(categoriaInstance);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Categoria trovaById(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (id == null || id < 1) {
                throw new Exception("Id invalido");
            }
            categoriaDAO.setEntityManager(entityManager);
            return categoriaDAO.get(id);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void setCategoriaDAO(CategoriaDAO categoriaDAOInstance) {
        this.categoriaDAO = categoriaDAOInstance;
    }
    @Override
    public void eliminaCategoriaCollegataAdArticolo(Categoria categoriaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            if (categoriaInstance == null) {
                throw new Exception("Valore in input non valido");
            }
            entityManager.getTransaction().begin();

            categoriaDAO.setEntityManager(entityManager);
            categoriaDAO.deleteCategoriaLinkedToArticoli(categoriaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Categoria trovaByIdEager(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try{
            if(id == null){
                throw new Exception("Problema valore in input");
            }
            categoriaDAO.setEntityManager(entityManager);
            return categoriaDAO.findByIdEager(id);
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
