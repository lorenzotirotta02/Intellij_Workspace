package it.prova.test;

import it.prova.model.Biglietto;

public class TestBiglietto {
    public static void main(String[] args){
        Biglietto b1 = new Biglietto("Teatro", 'A', "90", 179);
        Biglietto b2 = new Biglietto("Teatro", 'A', "90", 180);
        Biglietto[] elenco = {b1,b2};

        System.out.println("Inizio test trovaIlPiuEconomico....");
        Biglietto economico = Biglietto.trovaIlPiuEconomico(elenco);
        System.out.println(economico.getNomeSpettacolo() + "," + economico.getLetteraFila());
        System.out.println("Fine test trovaIlPiuEconomico....");

    }
}
