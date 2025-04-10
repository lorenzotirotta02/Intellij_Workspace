package it.prova.test;

import it.prova.model.Biglietto;
import it.prova.model.Spettatore;

public class TestSpettatore {
    public static void main(String[] args) {
        Spettatore s = new Spettatore("Mario", "Rossi", "4444",
                new Biglietto("1", 'A', "1", 15));

        Spettatore[] elenco = {new Spettatore("Mario", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Paolo", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Luigi", "Rossi", "4444", new Biglietto("1", 'A', "1", 15))};

        System.out.println("Inizio test incassoDeiPagantiNellaMiaFila...");
        System.out.println(s.incassoDeiPagantiNellaMiaFila(elenco));
        System.out.println("Fine test incassoDeiPagantiNellaMiaFila....");

        Spettatore s1 = new Spettatore("Maria", "Rossi", "4444",
                new Biglietto("1", 'A', "1", 15));

        Spettatore[] elenco1 = {new Spettatore("Mario", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Paolo", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Luigi", "Rossi", "4444", new Biglietto("1", 'A', "1", 15))};

        System.out.println("Inizio test numeroSpettatoriDelMioStessoSpettacolo...");
        System.out.println(s1.numeroSpettatoriDelMioStessoSpettacolo(elenco1));
        System.out.println("Fine test numeroSpettatoriDelMioStessoSpettacolo....");
    }
}
