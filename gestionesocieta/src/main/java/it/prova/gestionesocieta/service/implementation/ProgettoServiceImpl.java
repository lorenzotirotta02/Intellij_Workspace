package it.prova.gestionesocieta.service.implementation;

import it.prova.gestionesocieta.exception.SocietaInChiusuraException;
import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.repository.DipendenteRepository;
import it.prova.gestionesocieta.repository.ProgettoRepository;
import it.prova.gestionesocieta.service.abstraction.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProgettoServiceImpl implements ProgettoService {

    @Autowired
    private ProgettoRepository progettoRepository;
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Transactional
    @Override
    public void aggiungiProgetto(Progetto progettoInstance) {
        progettoRepository.save(progettoInstance);
    }

    @Override
    public void aggiornaProgetto(Progetto progettoInstance) {
        progettoRepository.save(progettoInstance);
    }

    @Override
    public void rimuoviProgetto(Long idProgetto) {
        progettoRepository.deleteById(idProgetto);
    }

    @Override
    public Optional<Progetto> caricaSingoloProgetto(Long idProgetto) {
       return progettoRepository.findById(idProgetto);
    }
    @Transactional
    @Override
    public void aggiungiDipendentiAProgetto(Progetto progetto, List<Dipendente> dipendente) {
        if (progetto == null || dipendente == null || progetto.getId() == null) {
            throw new Exception("Progetto o Dipendente non possono essere nulli");
        }
        for(Dipendente dipendente1 : dipendente) {
            if(dipendente1.getSocieta().getDataChiusura().isBefore(LocalDate.now().plusMonths(progetto.getDurataInMesi()))){
                throw new SocietaInChiusuraException("La societa' del dipendente " + dipendente1.getNome() + dipendente1.getCognome() + " e' in chiusura");
            }else {
                progetto.getDipendenti().add(dipendente1);
                dipendente1.getProgetti().add(progetto);
                dipendenteRepository.save(dipendente1);
            }
        }

    }

    @Override
    public List<Progetto> trovaTuttiIProgettiConRedditoAnnualeLordoMaggioreDi(int redditoAnnuoLordo) {
        if (redditoAnnuoLordo < 0) {
            throw new IllegalArgumentException("Il reddito annuo lordo deve essere maggiore di zero");
        }
        return progettoRepository.findAllByDipendenti_RedditoAnnuoLordoGreaterThanEqual(redditoAnnuoLordo);
    }

    @Override
    public List<Progetto> trovaTuttiIProgettiConDipendentiDiSocietaChiusa() {
        return progettoRepository.findAllByDipendentiWhereSocietaChiusa();
    }

}
