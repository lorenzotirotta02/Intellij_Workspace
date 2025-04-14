package it.prova.test;

import it.prova.model.Assicurato;

import java.util.ArrayList;
import java.util.List;

public class TestAssicurato {
    public static void main(String[] args){

        List<Assicurato> lista = new ArrayList<>();
        Assicurato persona = new Assicurato("Lorenzo", "Tirotta", "TRTLNZ02C22D005D", 500);
        Assicurato persona2 = new Assicurato("Marco", "Verdi", "MRCVRD18C99P004D", 400);
        Assicurato persona3 = new Assicurato("Alessandro", "Ancora", "ALSSANC44C09Y44O9", 450);
        lista.add(persona);
        lista.add(persona2);
        lista.add(persona3);

        System.out.println(persona.presenteInElenco(lista));

        int risultato = Assicurato.quantiConInizialeNelCognome(lista, 'A');
        System.out.println(risultato);

        List<Assicurato> risultato2 = Assicurato.estraiQuelliConRataMaggiore(lista, 450);
        System.out.println(risultato2);

        List<String> risultato3 = Assicurato.estraiSoloICognomi(lista);
        System.out.println(risultato3);
    }
}
