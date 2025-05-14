package it.prova.gestionetratte.service;

import it.prova.gestionetratte.exception.TrattaConIdNonEsistenteException;
import it.prova.gestionetratte.model.StatoTratta;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.TrattaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrattaServiceImpl implements TrattaService{

    @Autowired
    private TrattaRepository trattaRepository;

    @Override
    public Tratta inserisciNuovo(Tratta trattaInstance) {
        return trattaRepository.save(trattaInstance);
    }

    @Override
    public Tratta aggiorna(Tratta trattaInstance) {
        return trattaRepository.save(trattaInstance);
    }

    @Override
    public void rimuovi(Long idToRemove) {
        if (idToRemove == null || !trattaRepository.existsById(idToRemove)) {
            throw new TrattaConIdNonEsistenteException("Tratta con id " + idToRemove + "non esistente.");
        }
        trattaRepository.deleteById(idToRemove);
    }

    @Override
    public Tratta caricaSingoloElemento(Long id) {
        return trattaRepository.findById(id).orElseThrow(
                () -> new TrattaConIdNonEsistenteException("Tratta con id " + id + " non esistente.")
        );
    }

    @Override
    public Tratta caricaSingoloElementoEager(Long id) {
        return trattaRepository.findSingleTrattaEager(id);
    }

    @Override
    public List<Tratta> listAllElements(boolean eager) {
        return trattaRepository.findAllTratteEager();
    }


    @Override
    public List<Tratta> chiudiTratte(StatoTratta statoTratta) {
        List<Tratta> tratteAttive = trattaRepository.findTratteDaConcludere(StatoTratta.ATTIVA);

        for (Tratta tratta : tratteAttive) {
            if (LocalDateTime.now().isAfter(
                    LocalDateTime.of(tratta.getData(), tratta.getOraAtterraggio()))) {
                tratta.setStatoTratta(StatoTratta.CONCLUSA);
                trattaRepository.save(tratta);
            }
        }
        return tratteAttive;
    }
}
