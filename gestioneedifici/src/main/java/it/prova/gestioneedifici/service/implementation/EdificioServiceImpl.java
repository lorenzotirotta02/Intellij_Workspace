package it.prova.gestioneedifici.service.implementation;

import it.prova.gestioneedifici.exception.EdificioConDataCostruzionePrecedenteADataInserimentoException;
import it.prova.gestioneedifici.exception.PianiEdificioException;
import it.prova.gestioneedifici.model.Edificio;
import it.prova.gestioneedifici.repository.EdificioRepository;
import it.prova.gestioneedifici.service.abstraction.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class EdificioServiceImpl implements EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Transactional
    @Override
    public void inserimentoEdificio(Edificio edificio) {
        if (edificio == null) {
            throw new RuntimeException("Edificio non puo' essere null");
        }
        if (edificio.getDataCostruzione().isBefore(LocalDate.now())) {
            throw new EdificioConDataCostruzionePrecedenteADataInserimentoException("L'edificio non può avere una data di costruzione precedente alla data di inserimento");
        }
        if (edificio.getNumeroPiani() < 4) {
            throw new PianiEdificioException("L'edificio deve avere almeno 4 piani");
        }
        edificioRepository.save(edificio);
    }

    @Override
    public Map<Edificio, Integer> ottieniMappaInversa(Long id) {
        Map<Edificio, Integer> result = edificioRepository.ottieniMappaInversa(id);

        if (result.isEmpty()) {
            throw new RuntimeException("La mappa è vuota");
        }
        return result;
    }
}
