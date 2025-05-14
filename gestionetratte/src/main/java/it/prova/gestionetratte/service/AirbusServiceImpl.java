package it.prova.gestionetratte.service;

import it.prova.gestionetratte.dto.AirbusDTO;
import it.prova.gestionetratte.exception.AirbusConIdNonEsistenteException;
import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.AirbusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AirbusServiceImpl implements AirbusService{

    @Autowired
    private AirbusRepository airbusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Airbus> listAllElementsEager(boolean eager) {
        return airbusRepository.findAllEager();
    }

    @Override
    public Airbus caricaSingoloElementoEager(Long id) {
        return airbusRepository.findByIdEager(id);
    }

    @Override
    @Transactional
    public Airbus inserisciNuovo(Airbus airbusInstance) {
        return airbusRepository.save(airbusInstance);
    }

    @Override
    @Transactional
    public Airbus aggiorna(Airbus airbusInstance) {
        return airbusRepository.save(airbusInstance);
    }

    @Override
    @Transactional
    public void rimuovi(Long idToRemove) {
        Optional<Airbus> airbusOpt = airbusRepository.findById(idToRemove);

        if (airbusOpt.isEmpty()) {
            throw new AirbusConIdNonEsistenteException("Airbus con id " + idToRemove + " non esistente.");
        }

        Airbus airbus = airbusOpt.get();

        if (airbus.getTratte() != null && !airbus.getTratte().isEmpty()) {
            throw new RuntimeException("Impossibile rimuovere l'airbus: ha ancora tratte associate.");
        }

        airbusRepository.delete(airbus);
    }



    @Override
    @Transactional(readOnly = true)
    public Airbus caricaSingoloElemento(Long id) {
        return airbusRepository.findById(id).orElseThrow(
                () -> new AirbusConIdNonEsistenteException("Airbus con id " + id + " non esistente.")
        );
    }

    public List<AirbusDTO> trovaTuttiConSovrapposizioni() {
        List<Airbus> airbusList = airbusRepository.findAllEager();
        List<AirbusDTO> result = new ArrayList<>();

        for (Airbus a : airbusList) {
            List<Tratta> tratte = new ArrayList<>(a.getTratte());

            boolean sovrapposizioneTrovata = false;

            for (int i = 0; i < tratte.size(); i++) {
                Tratta t1 = tratte.get(i);
                LocalDateTime fine1 = LocalDateTime.of(t1.getData(), t1.getOraAtterraggio());

                for (int j = i + 1; j < tratte.size(); j++) {
                    Tratta t2 = tratte.get(j);
                    LocalDateTime inizio2 = LocalDateTime.of(t2.getData(), t2.getOraDecollo());

                    if (inizio2.isBefore(fine1)) {
                        sovrapposizioneTrovata = true;
                        break;
                    }
                }

                if (sovrapposizioneTrovata) break;
            }

            AirbusDTO dto = AirbusDTO.buildAirbusDTOFromModel(a, true);
            dto.setSovrapposizioni(sovrapposizioneTrovata);
            result.add(dto);
        }

        return result;
    }

}
