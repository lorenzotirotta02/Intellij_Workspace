package it.prova.gestionetratte.service;

import it.prova.gestionetratte.dto.AirbusDTO;
import it.prova.gestionetratte.model.Airbus;

import java.util.List;

public interface AirbusService {

    List<Airbus> listAllElementsEager(boolean eager);
    Airbus caricaSingoloElementoEager(Long id);
    Airbus inserisciNuovo(Airbus airbusInstance);
    Airbus aggiorna(Airbus airbusInstance);
    void rimuovi(Long idToRemove);
    Airbus caricaSingoloElemento(Long id);

    List<AirbusDTO> trovaTuttiConSovrapposizioni();

}
