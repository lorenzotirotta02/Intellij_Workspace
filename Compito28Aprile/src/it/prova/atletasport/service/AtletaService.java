package it.prova.atletasport.service;

import it.prova.atletasport.dao.AtletaDAO;
import it.prova.atletasport.dao.SportDAO;
import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

import java.util.List;

public interface AtletaService {

    public List<Atleta> listAll() throws Exception;

    public Atleta caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Atleta atletaInstance) throws Exception;

    public void inserisciNuovo(Atleta atletaInstance) throws Exception;

    public void rimuovi(Long idAtleta) throws Exception;

    public List<Atleta> trovaTuttiAtletiConSportChiuso() throws Exception; // trova tutti gli atleti con sport chiuso

    public Long sommaMedaglieDiAtletiConSportChiuso() throws Exception; // somma le medaglie di tutti gli atleti con sport chiuso

    public Atleta caricaAtletaSingoloConSport(Long id) throws Exception; // trova un atleta e lo carica con gli sport

    public List<Atleta> trovaTuttiAtletiBySport (Sport sport) throws Exception; // trova tutti gli atleti di uno sport

    public void setAtletaDAO(AtletaDAO atletaDAO);

    public void setSportDAO(SportDAO sportDAO);
}
