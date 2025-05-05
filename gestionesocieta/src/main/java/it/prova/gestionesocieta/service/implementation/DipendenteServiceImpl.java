package it.prova.gestionesocieta.service.implementation;

import it.prova.gestionesocieta.exception.SocietaInChiusuraException;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import it.prova.gestionesocieta.service.abstraction.DipendenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DipendenteServiceImpl implements DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Transactional
    @Override
    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    @Override
    public void aggiornaDipendente(Dipendente dipendente) {
        dipendenteRepository.save(dipendente);
    }

    @Override
    public void rimuoviDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }

    @Override
    public Optional<Dipendente> trovaDipendentePerId(Long id) {
        return dipendenteRepository.findById(id);
    }
    @Transactional
    @Override
    public void aggiungiProgetti(Dipendente dipendente, List<Progetto> progetto) throws Exception {
        if (dipendente == null || progetto == null || dipendente.getId() == null) {
            throw new Exception("Dipendente o Progetto non possono essere nulli");
        }
        for (Progetto progetto1 : progetto) {
            if (dipendente.getSocieta().getDataChiusura().isBefore(LocalDate.now().plusMonths(progetto1.getDurataInMesi()))) {
                throw new SocietaInChiusuraException("La societa' e' in chiusura, non puoi aggiungere un progetto");
            } else {
                dipendente.getProgetti().add(progetto1);
                dipendenteRepository.save(dipendente);
            }
        }
    }

    @Override
    public Dipendente trovaDipendentePerDataAssunzionePrimaDiDataFondazioneEDurataProgettoMaggioreDi(LocalDate dataFondazione, int durataInMesi) {
        return dipendenteRepository.findFirstByDataAssunzioneBeforeAndProgetti_DurataInMesiGreaterThanEqual(dataFondazione, durataInMesi);
    }
}
