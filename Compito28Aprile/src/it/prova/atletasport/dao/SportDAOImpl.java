package it.prova.atletasport.dao;

import it.prova.atletasport.model.Sport;
import it.prova.atletasport.model.SportUtente;

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
    public void addSportUtente(Long idUtente, Long idSport) throws Exception {

    }

    @Override
    public void removeSportUtente(Long idUtente, Long idSport) throws Exception {

    }

    @Override
    public void removeUtenteFromSport(Long idUtente, Long idSport) throws Exception {

    }
}
