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
    public int sumMedaglieBySportChiuso() throws Exception {
        return 0;
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


}
