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


    }
}
