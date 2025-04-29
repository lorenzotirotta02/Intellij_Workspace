package it.prova.gestioneordiniarticolicategorie.dao.articolo;

import it.prova.gestioneordiniarticolicategorie.model.Articolo;
import it.prova.gestioneordiniarticolicategorie.model.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class ArticoloDAOImpl implements ArticoloDAO{

    private EntityManager entityManager;


    @Override
    public List<Articolo> list() throws Exception {
        return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
    }

    @Override
    public Articolo get(Long id) throws Exception {
        return entityManager.find(Articolo.class, id);
    }

    @Override
    public void update(Articolo o) throws Exception {
        if(o == null){
            throw new Exception("Valore in input non valido");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(Articolo o) throws Exception {
        if(o == null){
            throw new Exception("Valore in input non valido");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Articolo o) throws Exception {
        if(o == null){
            throw new Exception("Valore in input non valido");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void deleteArticoloLinkedToCategorie(Articolo articoloInstance) throws Exception {
        if (articoloInstance == null) {
            throw new Exception("Valore in input non valido");
        }
        entityManager.createNativeQuery("delete from articolo_categoria where articolo_id = ?")
                .setParameter(1, articoloInstance.getId()).executeUpdate();
        entityManager.remove(entityManager.merge(articoloInstance));
    }
}
