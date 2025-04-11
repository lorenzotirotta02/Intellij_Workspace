package it.prova.test;

import it.prova.model.Animale;
import it.prova.model.Gatto;

public class TestAnimale {
    public static void main(String[] args){

        Animale generico = new Animale("bianco", "cinguetta");
        System.out.println(generico.versoCheFaIlMioAnimale());
        Animale gatto = new Gatto("nero", "miagola", 4);
        System.out.println(gatto.versoCheFaIlMioAnimale());

    }
}
