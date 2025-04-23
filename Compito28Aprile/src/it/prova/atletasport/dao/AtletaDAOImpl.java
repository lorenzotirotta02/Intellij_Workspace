package it.prova.atletasport.dao;

import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaDAOImpl implements AtletaDAO{

    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Atleta> list() throws Exception {
        return entityManager.createQuery("from Atleta", Atleta.class).getResultList();
    }

    @Override
    public Atleta get(Long id) throws Exception {
        return entityManager.find(Atleta.class, id);
    }

    @Override
    public void update(Atleta o) throws Exception {
        if(o == null) {
            throw new Exception("Atleta non valido");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(Atleta o) throws Exception {
        if (o == null){
            throw new Exception("Atleta non valido");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Atleta o) throws Exception {
        if(o == null) {
            throw new Exception("Atleta non valido");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public Long sumMedaglieBySportChiuso() throws Exception {
        return entityManager.createQuery("select sum(a.numeroMedaglieVinte) from Atleta a join a.sports s where s.dataFine < CURRENT_DATE", Long.class)
                .getSingleResult();
    }


    @Override
    public List<Atleta> findAllBySportChiuso() throws Exception {
        return List.of();
    }

    @Override
    public Atleta findByIdFetchingSport(Long id) throws Exception {
        return null;
    }

    @Override
    public List<Atleta> findAllBySport(Sport sport) throws Exception {
        return List.of();
    }

//    @Override
//    public List<Atleta> findAllBySportChiuso() throws Exception {
//        return entityManager.createQuery("select a from Atleta a join a.sports s where s.dataFine < CURRENT_DATE", Atleta.class)
//                .getResultList();
//    }
//
//    @Override
//    public Atleta findByIdFetchingSport(Long id) throws Exception {
//        if(id == null){
//            throw new Exception("Id non valido");
//        }
//        return entityManager.createQuery("select a from Atleta a left join fetch a.sports s where a.id = :id", Atleta.class)
//                .setParameter("id", id)
//                .getSingleResult();
//    }
//
//    @Override
//    public List<Atleta> findAllBySport(Sport sport) throws Exception {
//        if(sport == null){
//            throw new Exception("Sport non valido");
//        }
//        return entityManager.createQuery("select a from Atleta a join a.sports s where s = :sport", Atleta.class)
//                .setParameter("sport", sport)
//                .getResultList();
//    }


}
