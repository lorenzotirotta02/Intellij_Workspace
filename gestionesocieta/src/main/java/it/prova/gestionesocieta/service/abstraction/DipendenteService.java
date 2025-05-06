package it.prova.gestionesocieta.service.abstraction;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DipendenteService {

    void aggiungiDipendente(Dipendente dipendente);
    void aggiornaDipendente(Dipendente dipendente);
    void rimuoviDipendente(Long id);
    Optional<Dipendente> trovaDipendentePerId(Long id);
    void aggiungiProgetti(Dipendente dipendente, List<Progetto> progetto);
    Dipendente trovaDipendentePerDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi(LocalDate dataFondazione, int durataInMesi);
}
