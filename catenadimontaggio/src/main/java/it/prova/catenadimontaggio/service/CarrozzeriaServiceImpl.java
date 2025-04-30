package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class CarrozzeriaServiceImpl implements CarrozzeriaService{
    @Override
    public void esaminaCarrozzeria(Automobile automobile) {
        System.out.println("Esami alla carrozzeria dell'automobile " + automobile.getModello() + " effettuati...");
    }
}
