package it.prova.test;

import it.prova.model.*;

import java.util.Arrays;

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

        //TEST METODO AGGIUNGIMATERIALE
        MaterialeBiblioteca[] lista = {dvd, libro, rivista};
        Biblioteca biblioteca = new Biblioteca(lista);
        biblioteca.aggiungiMateriale    (libro1);
        System.out.println(Arrays.toString(biblioteca.getMateriali()));

        //TEST METODO CERCAMATERIALEPERTITOLO
        MaterialeBiblioteca[] lista2 = {dvd, libro, rivista, libro1};
        Biblioteca biblioteca1 = new Biblioteca(lista2);
        System.out.println(Arrays.toString(biblioteca1.cercaMaterialePerTitolo("Terminator")));

        //TEST METODO ELENCAMATERIALIDISPONBILI
        Rivista rivista2 = new Rivista("Finance", "Alessandro Rossi", false, "19098", "190", 2019);
        Libro libro2 = new Libro("1984", "George Orwell", true, "145", 300, "Romanzo");
        MaterialeBiblioteca[] lista3 = {libro1, libro2, rivista2};
        Biblioteca biblioteca2 = new Biblioteca(lista3);
        System.out.println(Arrays.toString(biblioteca2.elencaMaterialiDisponibili()));

        //TEST METODO ELENCAMATERIALIINPRESTITO
        Dvd dvd1 = new Dvd("Fast And Furious", "Warner", false, "1908243", 190);
        Rivista rivista3 = new Rivista("Finance", "Alessandro Rossi", false, "19098", "190", 2019);
        Libro libro3 = new Libro("1984", "George Orwell", true, "145", 300, "Romanzo");
        MaterialeBiblioteca[] lista4 = {libro3, rivista3, dvd1};
        Biblioteca biblioteca3 = new Biblioteca(lista4);
        System.out.println(Arrays.toString(biblioteca3.elencaMaterialiInPrestito()));
    }
}
