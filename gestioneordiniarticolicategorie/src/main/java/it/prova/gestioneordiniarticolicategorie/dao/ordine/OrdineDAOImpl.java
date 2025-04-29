package it.prova.gestioneordiniarticolicategorie.dao.ordine;

import it.prova.gestioneordiniarticolicategorie.model.Categoria;
import it.prova.gestioneordiniarticolicategorie.model.Ordine;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class OrdineDAOImpl implements OrdineDAO{


    private EntityManager entityManager;

    @Override
    public List<Ordine> list() throws Exception {
        return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
    }

    @Override
    public Ordine get(Long id) throws Exception {
        return entityManager.find(Ordine.class, id);
    }

    @Override
    public void update(Ordine o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(Ordine o) throws Exception {
        if (o == null){
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Ordine o) throws Exception {
        if(o == null){
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Ordine findByIdEager(Long id) throws Exception {
        if(id == null){
            throw new Exception("Problema valore in input");
        }
        return entityManager.createQuery("select distinct o from Ordine o left join fetch o.articoli a left join fetch a.categorie where o.id = :id", Ordine.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Ordine findPiuRecenteByCategoria(Long idCategoria) throws Exception {
        if (idCategoria == null) {
            throw new Exception("Problema valore in input");
        }
        return entityManager.createQuery("select o from Ordine o left join fetch o.articoli a left join fetch a.categorie c where c.id = :idCategoria order by o.dataSpedizione desc", Ordine.class)
                .setParameter("idCategoria", idCategoria)
                .getSingleResult();
    }

    @Override
    public boolean findByNomeDestinatario(String nomeDestinatario) throws Exception {
        if (nomeDestinatario == null) {
            throw new Exception("Problema valore in input");
        }
        Long count = entityManager.createQuery(
                        "select count(o) from Ordine o where o.nomeDestinatario = :nomeDestinatario", Long.class)
                .setParameter("nomeDestinatario", nomeDestinatario)
                .getSingleResult();
        return count > 0;

    }

    @Override
    public List<Ordine> findDistinctByStringInNumeroSeriale(String stringa) throws Exception {
        if (stringa == null){
            throw new Exception("Problema valore in input");
        }
        return entityManager.createQuery("select distinct o from Ordine o left join " +
                        "o.articoli a where a.numeroSeriale like :numeroSeriale", Ordine.class)
                .setParameter("numeroSeriale", "%" + stringa + "%")
                .getResultList();
    }
}
