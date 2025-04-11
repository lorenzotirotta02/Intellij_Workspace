package it.prova.test;

import it.prova.model.Lavoratore;
import it.prova.model.Operaio;
import it.prova.model.Volontario;

public class TestLavoratore {
    public static void main(String[] args){

        Lavoratore l = new Lavoratore("Mario" ,"Rossi");
        System.out.println(l.percepisco());

        Lavoratore p = new Operaio("Mario", "Bianchi", 1800);
        System.out.println(p.percepisco());

        Lavoratore x = new Volontario("Giacomo", "Neri", "Unicef");
        System.out.println(x.percepisco());

    }
}
