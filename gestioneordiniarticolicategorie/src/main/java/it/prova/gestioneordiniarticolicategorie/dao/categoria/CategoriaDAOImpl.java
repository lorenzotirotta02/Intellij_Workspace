package it.prova.gestioneordiniarticolicategorie.dao.categoria;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO {

    private EntityManager entityManager;

    @Override
    public List<Categoria> list() throws Exception {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria get(Long id) throws Exception {
        if (id == null) {
            throw new Exception("Problema valore in input");
        }
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void update(Categoria o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(Categoria o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Categoria o) throws Exception {
        if(o == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void deleteCategoriaLinkedToArticoli(Categoria categoriaInstance) throws Exception {
        if (categoriaInstance == null) {
            throw new Exception("Valore in input non valido");
        }
        entityManager.createNativeQuery("delete from articolo_categoria where categoria_id = ?")
                .setParameter(1, categoriaInstance.getId()).executeUpdate();
        entityManager.remove(entityManager.merge(categoriaInstance));
    }

    @Override
    public Categoria findByIdEager(Long id) throws Exception {
        if (id == null){
            throw new Exception("Problema valore in input");
        }
        return entityManager.createQuery("select c from Categoria c left join fetch c.articoli a where c.id = :id", Categoria.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
