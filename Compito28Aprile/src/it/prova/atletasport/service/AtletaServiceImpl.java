package it.prova.atletasport.service;

import it.prova.atletasport.dao.EntityManagerUtil;
import it.prova.atletasport.dao.SportDAO;
import it.prova.atletasport.dao.AtletaDAO;
import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaServiceImpl implements AtletaService{

    private AtletaDAO atletaDAO;
    private SportDAO sportDAO;

    @Override
    public void setAtletaDAO(AtletaDAO atletaDAO) {
        this.atletaDAO = atletaDAO;
    }

    @Override
    public void setSportDAO(SportDAO sportDAO) {
        this.sportDAO = sportDAO;
    }


    @Override
    public List<Atleta> listAll() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return atletaDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Atleta caricaSingoloElemento(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return atletaDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void aggiorna(Atleta atletaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            atletaDAO.update(atletaInstance);

            entityManager.getTransaction().commit();

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }finally{
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void inserisciNuovo(Atleta atletaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            atletaDAO.setEntityManager(entityManager);

            atletaDAO.insert(atletaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void rimuovi(Long idAtleta) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            atletaDAO.setEntityManager(entityManager);

            Atleta atletaInstance = atletaDAO.get(idAtleta);
            atletaDAO.delete(atletaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);

        }
    }

    @Override
    public List<Atleta> trovaTuttiAtletiConSportChiuso() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            atletaDAO.setEntityManager(entityManager);

            return atletaDAO.findAllBySportChiuso();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Long sommaMedaglieDiAtletiConSportChiuso() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            atletaDAO.setEntityManager(entityManager);

            return atletaDAO.sumMedaglieBySportChiuso();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Atleta caricaAtletaSingoloConSport(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            atletaDAO.setEntityManager(entityManager);
            Atleta atleta = atletaDAO.get(id); //conservo l'atleta.get(id) in una variabile
            // per evitare di fare due volte la stessa query

            if (atleta == null) {
                System.out.println("Atleta non trovato.");
                return null;
            }

            if (atleta.getSports() == null || atleta.getSports().isEmpty()) {
                System.out.println("L'atleta non ha sport associati.");
                return null;
            }

            return atleta;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }


    @Override
    public List<Atleta> trovaTuttiAtletiBySport(Sport sport) throws Exception {
        return List.of();
    }
}
