package it.prova.test;

import it.prova.model.Dvd;
import it.prova.model.Libro;
import it.prova.model.MaterialeBiblioteca;
import it.prova.model.Rivista;

public class TestMaterialeBiblioteca {
    public static void main(String[] args){
        //TEST MATERIALEBIBLIOTECA
        MaterialeBiblioteca libro1 = new MaterialeBiblioteca("Libro1", "Marco", true,"179");
        System.out.println(libro1.prestito());
        System.out.println("Il libro sarà disponibile in " + libro1.calcolaTempoPrestitoMassimo() + " giorni");
        System.out.println(libro1.restituzione());

        //TEST LIBRO
        Libro libro = new Libro("Sherlock Holmes", "Conan", true, "1902", 450, "Giallo");
        System.out.println(libro.prestito());
        System.out.println("Il libro sarà disponibile in " + libro.calcolaTempoPrestitoMassimo() + " giorni");
        System.out.println(libro.restituzione());

        //TEST RIVISTA
        Rivista rivista = new Rivista("Forbes", "Marco Bianchi", true, "1904", "14", 2025);
        System.out.println(rivista.prestito());
        System.out.println("La rivista sarà disponibile in " + rivista.calcolaTempoPrestitoMassimo() + " giorni");
        System.out.println(rivista.restituzione());

        //TEST DVD
        Dvd dvd = new Dvd("Terminator", "James Cameron", false, "129", 107);
        System.out.println(dvd.restituzione());
        System.out.println(dvd.prestito());
        System.out.println("Il dvd sarà disponibile in " + dvd.calcolaTempoPrestitoMassimo() + " giorni");


    }
}
