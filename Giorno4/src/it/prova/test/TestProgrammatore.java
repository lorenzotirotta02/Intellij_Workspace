package it.prova.test;

import it.prova.model.Programmatore;
import it.prova.model.Ufficio;

public class TestProgrammatore {
    public static void main(String[] args){

        Programmatore p = new Programmatore
                ("Lorenzo", "Tirotta", 23, "java",
                        new Ufficio("Solving team", "Via mosca 52", 23.7, "Cosenza"));
        System.out.println(p.getNome());


        Programmatore[] lista = {new Programmatore("Lorenzo", "Verdi", 28, "python",
                new Ufficio("Enel", "via roma", 39.1, "Cosenza")),
                new Programmatore("Giorgio", "Bianchi", 29, "java", new Ufficio("Alten", "Via mosca", 10.4, "Roma"))
        };
        System.out.println(p.quantiProgrammatoriNelMioUfficio(lista));
    }
}
