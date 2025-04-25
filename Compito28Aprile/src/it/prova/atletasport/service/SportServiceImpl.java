package it.prova.atletasport.service;

import it.prova.atletasport.validator.ValidateSportAndAtleta;
import it.prova.atletasport.dao.AtletaDAO;
import it.prova.atletasport.dao.EntityManagerUtil;
import it.prova.atletasport.dao.SportDAO;
import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

import static it.prova.atletasport.validator.ValidateSportAndAtleta.validateSportAndAtleta;

public class SportServiceImpl implements SportService{

    private SportDAO sportDAO;
    private AtletaDAO atletaDAO;

    @Override
    public void setSportDAO(SportDAO sportDao) {
        this.sportDAO = sportDao;
    }

    @Override
    public void setAtletaDAO(AtletaDAO atletaDao) {
        this.atletaDAO = atletaDao;
    }

    @Override
    public List<Sport> listAll() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            sportDAO.setEntityManager(entityManager);
            return sportDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public Sport caricaSingoloElemento(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            // Validazione dell'ID
            ValidateSportAndAtleta.validateSport(id);

            sportDAO.setEntityManager(entityManager);
            ValidateSportAndAtleta.validateSport(id);

            return sportDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }

    @Override
    public void aggiorna(Sport sportInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {

            // Validazione dell'ID
            Long sport = sportInstance.getId();
            ValidateSportAndAtleta.validateSport(sport);

            entityManager.getTransaction().begin();

            sportDAO.setEntityManager(entityManager);

            sportDAO.update(sportInstance);

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
    public void inserisciNuovo(Sport sportInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            sportDAO.setEntityManager(entityManager);

            sportDAO.insert(sportInstance);

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
    public void rimuovi(Long idSport) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // Validazione dell'ID
            ValidateSportAndAtleta.validateSport(idSport);

            entityManager.getTransaction().begin();
            sportDAO.setEntityManager(entityManager);

            Sport sportInstance = sportDAO.get(idSport);
            // Verifica che lo sport esista
            ValidateSportAndAtleta.validateSport(idSport);

            sportDAO.delete(sportInstance);
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
    public void rimuoviSportDaAtleta(Long idSport, Long idAtleta) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // Validazione degli ID
            ValidateSportAndAtleta.validateSportAndAtleta(idSport, idAtleta);
            entityManager.getTransaction().begin();

            sportDAO.setEntityManager(entityManager);
            atletaDAO.setEntityManager(entityManager);

            Sport sportInstance = sportDAO.get(idSport);
            Atleta atletaEsistente = atletaDAO.findByIdFetchingSport(idAtleta);

            // Verifica che lo sport e l'atleta esistano
            ValidateSportAndAtleta.validateSportAndAtleta(sportInstance, atletaEsistente);

            atletaEsistente.getSports().remove(sportInstance);
            atletaDAO.update(atletaEsistente);

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
    public void rimuoviAtletaDopoScollegamentoSport(Long idSport, Long idAtleta) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {
            // Validazione degli ID
            ValidateSportAndAtleta.validateSportAndAtleta(idSport, idAtleta);
            entityManager.getTransaction().begin();

            sportDAO.setEntityManager(entityManager);
            atletaDAO.setEntityManager(entityManager);

            Sport sportInstance = sportDAO.get(idSport);
            Atleta atletaEsistente = atletaDAO.findByIdFetchingSport(idAtleta);

            // Verifica che lo sport e l'atleta esistano
            ValidateSportAndAtleta.validateSportAndAtleta(sportInstance, atletaEsistente);

            if (atletaEsistente.getSports().contains(sportInstance)) {
                atletaEsistente.getSports().remove(sportInstance);
                atletaDAO.update(atletaEsistente);
            }

            atletaDAO.delete(atletaEsistente);

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
    public void aggiungiSportAtleta(Sport sportInstance, Long idAtleta) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            Long idSport = sportInstance.getId();

            // Validazione degli ID
            ValidateSportAndAtleta.validateSportAndAtleta(idSport, idAtleta);

            entityManager.getTransaction().begin();

            sportDAO.setEntityManager(entityManager);
            atletaDAO.setEntityManager(entityManager);

            Sport sportInstanceToAdd = sportDAO.get(sportInstance.getId());
            Atleta atletaEsistente = atletaDAO.findByIdFetchingSport(idAtleta);

            // Verifica che lo sport e l'atleta esistano
            ValidateSportAndAtleta.validateSportAndAtleta(sportInstance, atletaEsistente);

            if (atletaEsistente.getSports().contains(sportInstanceToAdd)) {
                throw new Exception("Sport già associato all'atleta");
            }

            atletaEsistente.getSports().add(sportInstanceToAdd);
            atletaDAO.update(atletaEsistente);

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
    public List<Sport> trovaSportConDateErrate() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            sportDAO.setEntityManager(entityManager);
            return sportDAO.findSportsWithWrongDateOrder();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }


}
