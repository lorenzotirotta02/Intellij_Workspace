package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class MotoreRicercaServiceImpl implements MotoreRicercaService{
    @Override
    public void controlloMotore(Automobile automobile) {
        System.out.println("Controllo del motore dell'automobile " + automobile + " effettuato...");
    }
}
