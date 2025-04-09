package it.prova.test;

import it.prova.model.Studente;

public class TestStudente {
    public static void main(String[] args) {
        Studente lorenzo = new Studente("Lorenzo", "Tirotta", 23, 7.2);
        Studente marco = new Studente("Marco", "Rossi", 22, 8.5);
        Studente giulia = new Studente("Giulia", "Verdi", 21, 9.1);
        Studente[] lista = {marco, giulia};

        System.out.println("Inizio test sonoTuttiPiuGiovaniDiMe.....");
        System.out.println(lorenzo.sonoTuttiPiuGiovaniDiMe(lista));
        System.out.println("Fine test sonoTuttiPiuGiovaniDiMe.....");

        Studente francesco = new Studente("Francesco", "Neri", 23, 7.2);
        Studente mario = new Studente("Mario", "Rossi", 22, 7.3);
        Studente maria = new Studente("Maria", "Verdi", 21, 6.1);
        Studente[] elenco = {mario, maria};

        System.out.println("Inizio test almenoUnoHaLaMediaMiglioreDellaMia.....");
        System.out.println(francesco.almenoUnoHaLaMediaMiglioreDellaMia(elenco));
        System.out.println("Fine test almenoUnoHaLaMediaMiglioreDellaMia.....");


        Studente francesca = new Studente("Francesca", "Neri", 19, 7.2);
        Studente fabrizio = new Studente("Fabrizio", "Rossi", 12, 7.3);
        Studente francescA = new Studente("Francesca", "Verdi", 11, 6.1);
        Studente gaia = new Studente("Gaia", "Bianchi", 21, 9.5);
        Studente[] elencoStudenti = {fabrizio, francescA, gaia};

        System.out.println("Inizio test quantiOmonimiMinorenniHo.....");
        System.out.println(francesca.quantiOmonimiMinorenniHo(elencoStudenti));
        System.out.println("Fine test quantiOmonimiMinorenniHo.....");

        Studente paolo = new Studente("Paolo", "Verdi", 20, 5.4);
        Studente giuseppe = new Studente("Giuseppe", "Rossi", 18, 5.9);
        Studente lorenza = new Studente("Lorenza", "Bianchi", 17, 4.9);
        Studente[] listaStudenti = {paolo, giuseppe, lorenza};

        System.out.println("Inizio test quanteMedieSopraLaSufficienza....");
        int conteggio = Studente.quanteMedieSopraLaSufficienza(listaStudenti);
        System.out.println(conteggio);
        System.out.println("Fine test quanteMedieSopraLaSufficienza....");

    }
}
