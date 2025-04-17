package it.prova.dao.televisore;

import it.prova.dao.IBaseDAO;
import it.prova.model.Televisore;

import java.time.LocalDate;
import java.util.List;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {
    public Televisore findTelevisorePiuGrande() throws Exception;
    public int countProdottiInUnIntervallo(LocalDate dataIniziale, LocalDate dataFinale) throws Exception;
    public List<Televisore> findTelevisoriProdottiNegliUltimiMesi(LocalDate dataInput) throws Exception;
}
