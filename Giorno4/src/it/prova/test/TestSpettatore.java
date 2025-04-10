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

        System.out.println("Inizio test numeroSpettatoriMioSpettacoloSuperaAspettativa....");
        System.out.println(s1.numeroSpettatoriMioSpettacoloSuperaAspettativa(elenco1, 5));

        Spettatore[] elenco3 = {new Spettatore("Lorenzo", "Rossi", "991019",null)};
        new Spettatore("Vincenzo","Verdi", "98909", new Biglietto("Teatro", 'a',"90",180));

        System.out.println("Inizio test contaQuantiSenzaBiglietto....");
        int conteggio = Spettatore.contaQuantiSenzaBiglietto(elenco3);
        System.out.println(conteggio);
        System.out.println("Fine test contaQuantiSenzaBiglietto....");

        Spettatore[] elencot = {new Spettatore("Mario", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Paolo", "Rossi", "4444", new Biglietto("1", 'A', "1", 15)),
                new Spettatore("Luigi", "Rossi", "4444", new Biglietto("1", 'A', "1", 15))};
        Spettatore s3 = new Spettatore("Mario", "Rossi", "4444",
                new Biglietto("1", 'A', "1", 15));
        System.out.println("Inizio test contaQuantiNellaMiaStessaFila...");
        System.out.println(s3.contaQuantiNellaMiaStessaFila(elencot));
    }
}
