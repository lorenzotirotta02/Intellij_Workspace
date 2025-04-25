package it.prova.atletasport.service;

import it.prova.atletasport.validator.ValidateSportAndAtleta;
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
            // Validazione dell'ID
            ValidateSportAndAtleta.validateAtleta(id);

            atletaDAO.setEntityManager(entityManager);

            // Recupero atleta
            Atleta atleta = atletaDAO.get(id);

            // Controllo esistenza
            ValidateSportAndAtleta.validateAtleta(atleta.getId());

            return atleta;

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
            // Validazione dell'ID
            Long atleta = atletaInstance.getId();
            ValidateSportAndAtleta.validateAtleta(atleta);


            entityManager.getTransaction().begin();
            atletaDAO.setEntityManager(entityManager);

            // Controllo se l'atleta esiste
            ValidateSportAndAtleta.validateAtleta(atleta);

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
            // Validazione dell'ID
            ValidateSportAndAtleta.validateAtleta(idAtleta);

            entityManager.getTransaction().begin();
            atletaDAO.setEntityManager(entityManager);
            Atleta atletaInstance = atletaDAO.get(idAtleta);

            // Controllo se l'atleta esiste
            ValidateSportAndAtleta.validateAtleta(atletaInstance.getId());

            // eseguo quello che realmente devo fare
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
            if(atletaDAO.findAllBySportChiuso() == null || atletaDAO.findAllBySportChiuso().isEmpty()) {
                System.out.println("Non ci sono atleti con sport chiuso.");
                return null;
            }
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
            if (atletaDAO.sumMedaglieBySportChiuso() == null || atletaDAO.sumMedaglieBySportChiuso() == 0) {
                System.out.println("Non ci sono atleti con sport chiuso.");
                return null;
            }

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
            // Validazione dell'ID
            ValidateSportAndAtleta.validateAtleta(id);

            atletaDAO.setEntityManager(entityManager);
            Atleta atleta = atletaDAO.get(id); //conservo l'atleta.get(id) in una variabile
            // per evitare di fare due volte la stessa query

            // Controllo se l'atleta esiste
            ValidateSportAndAtleta.validateAtleta(id);

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
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            // Validazione dell'ID
            ValidateSportAndAtleta.validateSport(sport.getId());

            atletaDAO.setEntityManager(entityManager);
            sportDAO.setEntityManager(entityManager);

            // Controllo se lo sport esiste
            ValidateSportAndAtleta.validateSport(sport.getId());

            return atletaDAO.findAllBySportChiuso();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }
}
