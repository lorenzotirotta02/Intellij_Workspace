package it.prova.atletasport.service;

import it.prova.atletasport.dao.AtletaDAO;
import it.prova.atletasport.dao.SportDAO;
import it.prova.atletasport.model.Atleta;

import java.util.List;

public interface AtletaService {

    public List<Atleta> listAll() throws Exception;

    public Atleta caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Atleta atletaInstance) throws Exception;

    public void inserisciNuovo(Atleta atletaInstance) throws Exception;

    public void rimuovi(Long idAtleta) throws Exception;

    public List<Atleta> trovaTuttiAtletiConSportChiuso() throws Exception;

    public int sommaMedaglieDiAtletiConSportChiuso() throws Exception;

    public void setAtletaDAO(AtletaDAO atletaDAO);

    public void setSportDAO(SportDAO sportDAO);
}
