package it.prova.service.televisore;

import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface TelevisoreService {
    public void setTelevisoreDao(TelevisoreDAO televisoreDao);

    public List<Televisore> listAll() throws Exception;

    public Televisore findById(Long idInput) throws Exception;

    public int aggiorna(Televisore input) throws Exception;

    public int inserisciNuovo(Televisore input) throws Exception;

    public int rimuovi(Long idDaRimuovere) throws Exception;

    public Televisore cercaIlPiuGrande() throws Exception;

    public int contaITelevisoriProdottiInUnIntervallo(LocalDate dataIniziale, LocalDate dataFinale) throws Exception;

    public List<Televisore> cercaPerMarcheDistinteTelevisoriProdottiNegliUltimiMesi(LocalDate dataInput) throws Exception;
}
