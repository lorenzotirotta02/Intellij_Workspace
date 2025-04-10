package it.prova.test;

import it.prova.model.Indirizzo;
import it.prova.model.Persona;

public class TestPersona {
    public static void main(String[] args){
        Indirizzo diP = new Indirizzo("Roma", "Via Mosca", "52");
        Persona p = new Persona("Lorenzo", "Tirotta", 18, diP);

        System.out.println(p.getIndirizzo());

        Indirizzo indirizzo = new Indirizzo("Roma", "Via Mosca", "40");
        Persona p1 = new Persona("Lorenzo", "Verdi", 18, indirizzo);
        System.out.println("Inizio test abitaA.....");
        System.out.println(p1.abitaA("Venezia"));
        System.out.println("Fine test abitaA.....");



        Indirizzo indirizzo4 = new Indirizzo("Roma", "Via Mosca", "53");
        Persona p2 = new Persona("Marco", "Rossi", 18, diP);
        Indirizzo indirizzo3 = new Indirizzo("Roma", "Via Mosca", "54");
        Persona p3 = new Persona("Gaia", "Bianchi", 18, diP);
        Persona[] elenco1 = {p2, p3};
        System.out.println("Inizio test haAlmenoUnConcittadino....");
        System.out.println(p.haAlmenoUnConcittadino(elenco1));
        System.out.println("Fine test haAlmenoUnConcittadino......");

        Indirizzo indirizzo2 = new Indirizzo("Roma", "Via Mosca", "41");
        Persona p4 = new Persona("Giulio", "Verdi", 18, diP);
        Indirizzo indirizzo1 = new Indirizzo("Roma", "Via Mosca", "42");
        Persona p5 = new Persona("Lorenzo", "Bianchi", 18, diP);
        Persona[] elenco2 = {p4, p5};
        System.out.println("Inizio test sonoTuttiPiuAnziani....");
        System.out.println(p.sonoTuttiPiuAnziani(elenco2));
        System.out.println("Fine test sonoTuttiPiuAnziani....");

        Indirizzo indirizzoP1 = new Indirizzo("Venezia", "Via Roma", "4");
        Persona p10 = new Persona("Giulio", "Verdi", 45,indirizzoP1);
        Indirizzo indirizzoP2 = new Indirizzo("Venezia", "Via Spagna", "4");
        Persona p11 = new Persona("Lorenzo", "Neri", 43,indirizzoP2);
        Persona[] elencoInput = {p10, p11};
        Persona p12 = new Persona("Mario", "Rossi", 45, indirizzoP1);
        System.out.println("Inizio test quantiCoabitanoNelMioStessoPalazzo....");
        System.out.println(p12.quantiCoabitanoNelMioStessoPalazzo(elencoInput));
        System.out.println("Fine test quantiCoabitanoNelMioStessoPalazzo");
    }
}
