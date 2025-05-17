package it.prova.pokeronline.service.abstraction;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

import java.util.List;

public interface UtenteService {

    void inserisciUtente(Utente utente);

    void aggiornaUtente(Utente utente);

    void disabilitaUtente(Long idUtente);

    Utente caricaSingoloUtente(Long idUtente);

    void compraCredito(Integer credito);

    Tavolo restituisciUltimoTavolo();

    void abbandonaPartita();

    List<Tavolo> trovaTavoloCompatibileConUtente();

    void giocaPartita(Long idTavolo);


}
