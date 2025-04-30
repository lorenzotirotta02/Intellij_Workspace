package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class ImpiantoElettricoServiceImpl implements ImpiantoElettricoService{

    @Override
    public void controlloImpiantoElettrico(Automobile automobile) {
        System.out.println("Controllo impianto elettrico dell'automobile " + automobile.getModello() + " effettuato...");
    }
}
