package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class TestPopulateArticoli {
    public static void main(String[] args) {
        NegozioDAO negozioDAO = new NegozioDAO();

        Negozio negozio = negozioDAO.findById(1L);
        System.out.println(negozio);

        negozioDAO.populateArticoli(negozio);

        System.out.println(negozio.getArticoli());

    }
}

