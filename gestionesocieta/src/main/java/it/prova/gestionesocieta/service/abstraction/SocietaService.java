package it.prova.gestionesocieta.service.abstraction;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;

import java.util.List;
import java.util.Optional;

public interface SocietaService {

    void aggiungiSocieta(Societa societa) throws Exception;
    void modificaSocieta(Societa societa);
    void eliminaSocieta(Long id);
    Optional<Societa> trovaSocietaPerId(Long id);
    List<Societa> findByExample(Societa example);
    List<Dipendente> trovaDipendentiPerSocieta(Long id);
    List<String> trovaTuttiIClientiPerSocieta(Long id);
    List<String> trovaTuttiINomeSocietaConProgettiDurataMaggioreDiUnAnno();
    List<Societa> trovaTuttiIDipendentiConDataAssunzioneDopoDataFondazione();


}
