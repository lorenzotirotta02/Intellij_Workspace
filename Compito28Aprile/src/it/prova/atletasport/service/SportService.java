package it.prova.atletasport.service;

import it.prova.atletasport.dao.AtletaDAO;
import it.prova.atletasport.dao.SportDAO;
import it.prova.atletasport.model.Sport;

import java.util.List;

public interface SportService {

    public List<Sport> listAll() throws Exception;

    public Sport caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Sport sportInstance) throws Exception;

    public void inserisciNuovo(Sport sportInstance) throws Exception;

    public void rimuovi(Long idSport) throws Exception;

    public void rimuoviSportDaAtleta(Long idSport, Long idAtleta) throws Exception;

    public void rimuoviAtletaDopoScollegamentoSport(Long idSport, Long idAtleta) throws Exception;

    public void aggiungiSportAtleta(Sport sportInstance, Long idAtleta) throws Exception;

    public List<Sport> trovaSportConDateErrate() throws Exception;

    public void setSportDAO(SportDAO sportDao);

    public void setAtletaDAO(AtletaDAO atletaDao);
}
