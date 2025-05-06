package it.prova.gestioneedifici.service.implementation;

import it.prova.gestioneedifici.exception.InquilinoMinorenneException;
import it.prova.gestioneedifici.exception.NumeroMassimoPerPianoException;
import it.prova.gestioneedifici.model.Inquilino;
import it.prova.gestioneedifici.repository.InquilinoRepository;
import it.prova.gestioneedifici.service.abstraction.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
@Transactional(readOnly = true)
public class InquilinoServiceImpl implements InquilinoService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Transactional
    @Override
    public void inserisciInquilino(Inquilino inquilino) {
        if(inquilino == null ){
            throw new RuntimeException("Inquilino non puo' essere null");
        }

        int eta = Period.between(inquilino.getDataNascita(), LocalDate.now()).getYears();

        if(eta < 18 && inquilino.getAffittoDovuto() != null){
            throw new InquilinoMinorenneException("L'inquilino non ha 18 anni, non paga l'affitto");
        }

        int maxNumero = inquilino.getEdificio().getNumeroPiani() * 16;
        if(inquilino.getEdificio().getInquilini().size() >= maxNumero){
            throw new NumeroMassimoPerPianoException("L'edificio ha raggiunto il numero massimo di inquilini");
        }
        inquilinoRepository.save(inquilino);
    }
}
