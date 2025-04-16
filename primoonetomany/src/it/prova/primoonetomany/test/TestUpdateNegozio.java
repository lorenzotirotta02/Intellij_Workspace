package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Negozio;

import java.time.LocalDate;

public class TestUpdateNegozio {
    public static void main(String[] args){
        NegozioDAO negozioDAO = new NegozioDAO();

        Negozio negozio = new Negozio();
        negozio.setId(1L);
        negozio.setNome("NegozioProva");
        negozio.setIndirizzo("Via Esempio 10, Milano");
        negozio.setDataApertura(LocalDate.of(2019, 5, 20));

        int recordAggiornati = negozioDAO.update(negozio);

        System.out.println("Numero di record aggiornati: " + recordAggiornati);
    }
}
