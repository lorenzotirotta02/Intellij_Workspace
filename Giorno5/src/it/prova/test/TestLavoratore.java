package it.prova.test;

import it.prova.model.Lavoratore;
import it.prova.model.Operaio;
import it.prova.model.Volontario;

public class TestLavoratore {
    public static void main(String[] args){

        Lavoratore l = new Lavoratore("Mario" ,"Rossi");
        System.out.println(l.percepisco());

        Operaio p = new Operaio("Mario", "Bianchi", 1800);
        System.out.println(p.percepisco());

        Lavoratore x = new Volontario("Giacomo", "Neri", "Unicef");
        System.out.println(x.percepisco());

        Lavoratore[] lavoratores = {l, p, x};
        int count = Lavoratore.quantiPadri(lavoratores);
        System.out.println(count);

        int conteggio = Operaio.contaQuantiFigli(lavoratores);
        System.out.println(conteggio);
    }
}
