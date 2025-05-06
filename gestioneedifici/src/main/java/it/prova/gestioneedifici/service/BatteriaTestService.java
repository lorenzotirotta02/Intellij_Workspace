package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.model.Edificio;
import it.prova.gestioneedifici.model.Inquilino;
import it.prova.gestioneedifici.service.abstraction.EdificioService;
import it.prova.gestioneedifici.service.abstraction.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BatteriaTestService {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private InquilinoService inquilinoService;

    public void testInserimentoEdificio(){
        System.out.println("################ START   #################");

        Edificio edificio = new Edificio("Via Roma", "Milano", LocalDate.of(2029, 6, 1) ,3);
        edificioService.inserimentoEdificio(edificio);
        if (edificio.getId() != null && edificio.getId() > 0) {
            System.out.println("Edificio inserito con successo: " + edificio);
        } else {
            throw new RuntimeException("Errore durante l'inserimento dell'edificio.");
        }
    }
    public void testInserimentoInquilino(){
        System.out.println("################ START   #################");
        Edificio edificio = new Edificio("Via Roma", "Bari", LocalDate.of(2026, 6, 1) ,5);

//        List<Inquilino> listaFinta = new ArrayList<>();
//        for (int i = 0; i < 80; i++) {
//            listaFinta.add(new Inquilino()); //UTILIZZATO PER TESTARE L'EXCEPTION PIANIEDIFICIOEXCEPTION
//        }
//        edificio.setInquilini(listaFinta);

        edificioService.inserimentoEdificio(edificio);

        Inquilino inquilino = new Inquilino("Mario", "Rossi", LocalDate.of(2000, 1, 1), 500L);
        inquilinoService.inserisciInquilino(inquilino , edificio.getId());

        if (inquilino.getId() != null && inquilino.getId() > 0) {
            System.out.println("Inquilino inserito con successo: " + inquilino);
        } else {
            throw new RuntimeException("Errore durante l'inserimento dell'inquilino.");
        }
    }
    public void testOttieniMappaInversa(){
        System.out.println("################ START   #################");

        Map<Edificio, Integer> result = edificioService.ottieniMappaInversa(3L);
        for (Edificio k : result.keySet()) {
            System.out.println("Edificio: " + k + ", Numero di inquilini: " + result.get(k));
        }

    }
}
