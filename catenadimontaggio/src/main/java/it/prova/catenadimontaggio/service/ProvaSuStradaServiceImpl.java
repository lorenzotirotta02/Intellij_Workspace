package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class ProvaSuStradaServiceImpl implements ProvaSuStradaService{
    @Override
    public void esaminaProvaSuStrada(Automobile automobile) {
        System.out.println("Prova su strada dell'automobile " + automobile.getModello() + " effettuata...");
    }
}
