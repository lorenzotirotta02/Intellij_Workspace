package it.prova.pokeronline.service.implementation;

import it.prova.pokeronline.exception.*;
import it.prova.pokeronline.model.Stato;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.TavoloRepository;
import it.prova.pokeronline.repository.UtenteRepository;
import it.prova.pokeronline.service.abstraction.TavoloService;
import it.prova.pokeronline.service.abstraction.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private TavoloRepository tavoloRepository;

    @Override
    public void inserisciUtente(Utente utente) {
        if(utente == null) {
            throw new IllegalArgumentException("ID utente non può essere nullo.");
        }
        utenteRepository.save(utente);
    }

    @Override
    public void aggiornaUtente(Utente utente) {
        if(utente == null) {
            throw new IllegalArgumentException("L'utente non può essere nullo.");
        }
        Utente utenteLoggato = recuperaUtenteLoggato();

        if(utenteLoggato.getRuolo().getCodice().equals("ADMIN") || utenteLoggato.getId().equals(utente.getId())) {
            utenteRepository.save(utente);
        }else{
            throw new UtenteNonAutorizzatoException("Non sei autorizzato a modificare questo utente.");
        }
    }

    @Override
    public void disabilitaUtente(Long idUtente) {
        if(idUtente == null) {
            throw new IllegalArgumentException("ID utente non può essere nullo.");
        }
        Utente utente = recuperaUtenteLoggato();
        if(utente.getRuolo().getCodice().equals("ADMIN")) {
            Utente utenteDaDisabilitare = utenteRepository.findById(idUtente).orElseThrow(() ->
                    new UtenteNonTrovatoException("Nessun utente trovato con ID: " + idUtente));
            utenteDaDisabilitare.setStato(Stato.DISABILITATO);
        }else{
            throw new UtenteNonAutorizzatoException("Non sei autorizzato a disabilitare questo utente.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Utente caricaSingoloUtente(Long idUtente) {
        if(idUtente == null) {
            throw new IllegalArgumentException("ID utente non può essere nullo.");
        }
        Utente utente = recuperaUtenteLoggato();
        if(utente.getRuolo().getCodice().equals("ADMIN")){
            return utenteRepository.findById(idUtente).orElseThrow(() ->
                    new UtenteNonTrovatoException("Nessun utente trovato con ID: " + idUtente));
        }
        throw new UtenteNonAutorizzatoException("Utente non autorizzato a cercare questo utente.");
    }

    @Transactional
    public void compraCredito(Integer credito) {
        if (credito == null || credito <= 0) {
            throw new IllegalArgumentException("Il credito deve essere un valore positivo.");
        }
        Utente utente = recuperaUtenteLoggato();

        utente.setCreditoAccumulato(credito + utente.getCreditoAccumulato());
        utenteRepository.save(utente);
    }

    @Override
    public Tavolo restituisciUltimoTavolo() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare il tavolo.");
        }
        if(utente.getTavolo() == null) {
            throw new UtenteNonAutorizzatoException("Non appartieni a nessun tavolo.");
        }
        return utenteRepository.findLastGameByUtenteId(utente.getId()).get();
    }

    @Override
    public void abbandonaPartita() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare il tavolo.");
        }
        if(utente.getTavolo() == null) {
            throw new UtenteNonAutorizzatoException("Non appartieni a nessun tavolo.");
        }
        utente.setTavolo(null);
        utenteRepository.save(utente);
    }

    @Override
    public List<Tavolo> trovaTavoloCompatibileConUtente() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare un tavolo compatibile.");
        }
        List<Tavolo> tavoli = utenteRepository.findTavoliCompatibilePerUtente(utente.getId());
        if(tavoli.isEmpty()){
            throw new TavoloNonTrovatoException("Nessun tavolo trovato compatibile con l'utente.");
        }
        return tavoli;
    }

    @Override
    public void giocaPartita(Long idTavolo) {
        Utente utente = recuperaUtenteLoggato();

        Tavolo tavolo = tavoloRepository.findById(idTavolo).orElseThrow(() ->
                new TavoloNonTrovatoException("Nessun tavolo trovato con ID: " + idTavolo));

        if (utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per giocare una partita.");
        }

        if (utente.getEsperienzaAccumulata() < tavolo.getEsperienzaMin()) {
            throw new EsperienzaInsufficienteException("Esperienza insufficiente per accedere al tavolo.");
        }

        if (utente.getCreditoAccumulato() < tavolo.getCifraMinima()) {
            throw new CreditoInsufficienteException("Credito insufficiente per giocare a questo tavolo.");
        }

        // Simulazione partita (50% di possibilità)
        boolean vinto = Math.random() < 0.5;

        if (vinto) {
            utente.setEsperienzaAccumulata(utente.getEsperienzaAccumulata() + 50);
            utente.setCreditoAccumulato(utente.getCreditoAccumulato() + 100);
            System.out.println("Hai vinto! +50 XP, +100 credito.");
        } else {
            utente.setCreditoAccumulato(utente.getCreditoAccumulato() - tavolo.getCifraMinima());
            System.out.println("Hai perso! -" + tavolo.getCifraMinima() + " credito.");
        }

        if(utente.getStato().equals(Stato.CREATO)){
            utente.setStato(Stato.ATTIVO);
        }

        utenteRepository.save(utente);
    }



    private Utente recuperaUtenteLoggato(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return utenteRepository.findByUsername(username)
                    .orElseThrow(() -> new UtenteNonTrovatoException("Utente non trovato"));
        }
        throw new UtenteNonTrovatoException("Utente non trovato");
    }

}
