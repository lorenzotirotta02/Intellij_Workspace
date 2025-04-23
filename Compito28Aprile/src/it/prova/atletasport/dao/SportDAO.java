package it.prova.atletasport.dao;

import it.prova.atletasport.model.Sport;
import it.prova.atletasport.model.SportUtente;

public interface SportDAO extends IBaseDAO<Sport>{

    public void addSportUtente(Long idUtente, Long idSport) throws Exception;

    public void removeSportUtente(Long idUtente, Long idSport) throws Exception;

    public void removeUtenteFromSport(Long idUtente, Long idSport) throws Exception;
}
