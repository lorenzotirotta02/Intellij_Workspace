package it.prova.gestionesocieta.service.abstraction;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;

import java.util.List;
import java.util.Optional;

public interface ProgettoService {

    void aggiungiProgetto(Progetto progettoInstance);
    void aggiornaProgetto(Progetto progettoInstance);
    void rimuoviProgetto(Long idProgetto);
    Optional<Progetto> caricaSingoloProgetto(Long idProgetto);
    void aggiungiDipendentiAProgetto(Progetto progetto, List<Dipendente> dipendente) throws Exception;
    List<Progetto> trovaTuttiIProgettiConRedditoAnnualeLordoMaggioreDi(int redditoAnnuoLordo);
    List<Progetto> trovaTuttiIProgettiConDipendentiDiSocietaChiusa();


}
