package it.prova.test;

import it.prova.model.MaterialeBiblioteca;

public class TestMaterialeBiblioteca {
    public static void main(String[] args){

        MaterialeBiblioteca libro1 = new MaterialeBiblioteca("Libro1", "Marco", true,"179");
        System.out.println(libro1.prestito());
        System.out.println("Il libro sarà disponibile in " + libro1.calcolaTempoPrestitoMassimo() + " giorni");
        System.out.println(libro1.restituzione());
    }
}
