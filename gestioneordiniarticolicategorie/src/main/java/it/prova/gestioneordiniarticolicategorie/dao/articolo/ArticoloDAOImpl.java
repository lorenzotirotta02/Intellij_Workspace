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
    @Override
    public double sumAllPrezziDiArticoliLinkedToOneCategoria(Long id) throws Exception{
        if (id == null){
            throw new Exception("Valore in input non valido");
        }
        return entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.categorie c where c.id = :id", Double.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public double sumAllPrezziDiArticoliWithNomeDestinatario(String nomeDestinatario) throws Exception {
        if (nomeDestinatario == null){
            throw new Exception("Valore in input non valido");
        }
        return entityManager.createQuery("select sum(a.prezzoSingolo) from Articolo a join a.ordine o where o.nomeDestinatario = :nomeDestinatario", Double.class)
                .setParameter("nomeDestinatario", nomeDestinatario)
                .getSingleResult();
    }

    @Override
    public List<Articolo> findAllWithDataSpedizioneAfterDataDiScadenza() throws Exception {
        return entityManager.createQuery("select a from Articolo a " +
                        "left join a.ordine o where o.dataSpedizione > o.dataScadenza", Articolo.class)
                .getResultList();
    }
}
