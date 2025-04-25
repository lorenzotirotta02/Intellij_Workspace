package it.prova.atletasport.dao;

import it.prova.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class SportDAOImpl implements SportDAO{

    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Sport> list() throws Exception {
        return entityManager.createQuery("from Sport", Sport.class).getResultList();
    }

    @Override
    public Sport get(Long id) throws Exception {
        return entityManager.find(Sport.class, id);
    }

    @Override
    public void update(Sport o) throws Exception {
        if(o == null) {
            throw new Exception("Sport non valido");
        }
        o = entityManager.merge(o);
    }

    @Override
    public void insert(Sport o) throws Exception {
        if (o == null){
            throw new Exception("Sport non valido");
        }
        entityManager.persist(o);
    }

    @Override
    public void delete(Sport o) throws Exception {
        if(o == null) {
            throw new Exception("Sport non valido");
        }
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public void addSportAtleta(Long idUtente, Long idSport) throws Exception {
        if(idUtente == null || idSport == null) {
            throw new Exception("Id utente o sport non valido");
        }
        entityManager.createNativeQuery("insert into atleta_sport (id_utente, id_sport) values (?, ?)")
                .setParameter(1, idUtente)
                .setParameter(2, idSport)
                .executeUpdate();
    }

    @Override
    public void removeSportAtleta(Long idUtente, Long idSport) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("delete from atleta_sport where id_utente = ? and id_sport = ?")
                    .setParameter(1, idUtente)
                    .setParameter(2, idSport)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void removeAtletaAfterRemovingFromSport(Long idUtente, Long idSport) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("delete from atleta_sport where id_utente = ? and id_sport = ?")
                    .setParameter(1, idUtente)
                    .setParameter(2, idSport)
                    .executeUpdate();
            entityManager.createNativeQuery("delete from atleta where a.id = ?")
                    .setParameter(1, idUtente)
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }
    @Override
    public List<Sport> findSportsWithWrongDateOrder() throws Exception {
        return entityManager.createQuery("select s from Sport s where s.dataInizio > s.dataFine", Sport.class)
                .getResultList();
    }
}
