package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

import java.util.List;

public class TestFindAllByNegozio {
    public static void main(String[] args) {
        ArticoloDAO dao = new ArticoloDAO();

        Negozio negozio = new Negozio();
        negozio.setId(1L);
        List<Articolo> articoliByNegozio = dao.findAllByNegozio(negozio);
        Articolo primoArticolo = articoliByNegozio.get(0);
        System.out.println("Articoli trovati per negozio con ID 1: " + primoArticolo);
    }
}
