package it.prova.test;

import it.prova.model.*;

import java.util.ArrayList;
import java.util.List;

public class TestHotel {
    public static void main(String[] args){




        Hotel hotel = new Hotel("Turismo", 5);
        Stanza s = new Stanza(790, 80, hotel);
        ArrayList<Stanza> stanze = new ArrayList<>();
        stanze.add(s);
        Premio p = new Premio("Lorenzo", "Tirotta", s);
        Turista t = new Turista("Marco", "Verdi", s);
        Rappresentante r = new Rappresentante("Alessandro", "Bianchi", s);
        ArrayList<Cliente> listaClienti= new ArrayList<>();
        listaClienti.add(p);
        listaClienti.add(t);
        listaClienti.add(r);

        s.setClienti(listaClienti);
        hotel.setStanze(stanze);




        System.out.println(hotel.calcolaConto(stanze.getFirst()));

    }
}
