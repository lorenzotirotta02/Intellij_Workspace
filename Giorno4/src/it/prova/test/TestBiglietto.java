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

        Biglietto b3 = new Biglietto("Teatro", 'A', "90", 179);
        Biglietto b4 = new Biglietto("Teatro", 'A', "91", 180);
        Biglietto b5 = new Biglietto("Teatro", 'A', "91", 180);
        Biglietto[] elenco1 = {b3,b4};
        System.out.println("Inizio test bigliettoAncoraInvenduto....");
        System.out.println(b5.bigliettoAncoraInvenduto(elenco1));
        System.out.println("Fine test bigliettoAncoraInvenduto....");

        Biglietto[] elencoB = {new Biglietto("Teatro", 'a', "90", 190),
        new Biglietto("Cinema", 'a', "91",170)};
        String s = "Teatro";
        boolean L = Biglietto.sonoTuttiBigliettiPerLoSpettacoloIntitolato(elencoB, s);
        System.out.println("Inizio test sonoTuttiBigliettiPerLoSpettacoloIntitolato...");
        System.out.println(L);
        System.out.println("Fine test sonoTuttiBigliettiPerLoSpettacoloIntitolato...");
    }
}
