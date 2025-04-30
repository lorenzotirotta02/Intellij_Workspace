package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class TelaioServiceImpl implements TelaioService{

    @Override
    public void esaminaTelaio(Automobile automobile) {
        System.out.println("Il telaio dell'automobile " + automobile.getModello() + " è stato esaminato.");
    }
}
