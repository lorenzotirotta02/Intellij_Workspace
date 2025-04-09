package it.prova.test;

import it.prova.model.Persona;

public class TestPersona {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNome("Mario");
        p.setCognome("Rossi");
        p.setEta(18);


        Persona p2 = new Persona();
        p2.setNome("Luigi");
        p2.setCognome("Rossi");
        p2.setEta(20);

        System.out.println(p2.ePiuAnzianoDi(p));

    }
    //Realizzare una classe Televisore con marca modello pollici e prezzo
    //

}
