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
    }
}
