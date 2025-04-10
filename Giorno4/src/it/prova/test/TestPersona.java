package it.prova.test;

import it.prova.model.Indirizzo;
import it.prova.model.Persona;

import java.util.Arrays;

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
        Indirizzo indirizzoP2 = new Indirizzo("Venezia", "Via Roma", "4");
        Persona p11 = new Persona("Lorenzo", "Neri", 43,indirizzoP2);
        Persona[] elencoInput = {p10, p11};
        Persona p12 = new Persona("Mario", "Rossi", 45, indirizzoP1);
        System.out.println("Inizio test quantiCoabitanoNelMioStessoPalazzo....");
        System.out.println(p12.quantiCoabitanoNelMioStessoPalazzo(elencoInput));
        System.out.println("Fine test quantiCoabitanoNelMioStessoPalazzo");

        Indirizzo indirizzo5 = new Indirizzo("Roma", "Via Mosca", "50");
        Indirizzo indirizzo4 = new Indirizzo("Roma", "Via Mosca", "53");
        Persona p15 = new Persona("Giulio", "Neri", 19, indirizzo5);
        Persona p16 = new Persona("Mario", "Verdi", 69, indirizzo4);
        System.out.println("Inizio test nuovoCoinquilino....");
        p15.nuovoCoinquilino(p16);
        System.out.println("Il nuovo indirizzo di Mario è " +  p16.getIndirizzo().getCitta());
        System.out.println("Fine test nuovoCoinquilino....");

        Persona[] elencoInput2 = {
                new Persona("Giorgio", "Rossi", 89, new Indirizzo("Roma", "via Roma", "5")),
                new Persona("Giorgio", "Rossi", 65, new Indirizzo("Roma", "via Roma", "5")),
        };

        System.out.println("Inizio test restituiscimiIndirizzi....");
        Indirizzo[] elenco4 = Persona.restituiscimiIndirizzi(elencoInput2);
        for(int i = 0; i < elenco4.length; i++){
            System.out.println(elenco4[i].getCitta() + "," + elenco4[i].getVia() + "," + elenco4[i].getCivico());
        }

    }
}
