package it.prova.atletasport.dao;

import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

import java.util.List;

public interface AtletaDAO extends IBaseDAO<Atleta>{

    public int sumMedaglieBySportChiuso() throws Exception;

    public List<Atleta> findAllBySportChiuso() throws Exception;

    public Atleta findByIdFetchingSport(Long id) throws Exception;

    public List<Atleta> findAllBySport(Sport sport) throws Exception;
}
