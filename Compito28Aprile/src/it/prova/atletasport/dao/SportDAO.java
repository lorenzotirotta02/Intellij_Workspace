package it.prova.atletasport.dao;

import it.prova.atletasport.model.Sport;

public interface SportDAO extends IBaseDAO<Sport>{

    public void addSportAtleta(Long idUtente, Long idSport) throws Exception;

    public void removeSportAtleta(Long idUtente, Long idSport) throws Exception;

    public void removeAtletaAfterRemovingFromSport(Long idUtente, Long idSport) throws Exception;
}
