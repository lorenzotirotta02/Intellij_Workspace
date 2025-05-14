package it.prova.gestionetratte.service;

import it.prova.gestionetratte.model.StatoTratta;
import it.prova.gestionetratte.model.Tratta;

import java.util.List;

public interface TrattaService {

    Tratta inserisciNuovo(Tratta trattaInstance);
    Tratta aggiorna(Tratta trattaInstance);
    void rimuovi(Long idToRemove);
    Tratta caricaSingoloElemento(Long id);

    Tratta caricaSingoloElementoEager(Long id);

    List<Tratta> listAllElements(boolean eager);

    List<Tratta> chiudiTratte(StatoTratta statoTratta);

}
