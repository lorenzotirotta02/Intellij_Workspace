package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class TestUpdateArticolo {
    public static void main(String[] args) {
        ArticoloDAO articoloDAO = new ArticoloDAO();
        Negozio negozio = new Negozio();
        negozio.setId(1L);

        Articolo articolo = new Articolo();
        articolo.setId(5L);
        articolo.setNome("Articolo Aggiornato");
        articolo.setMatricola("XYZ987");
        articolo.setNegozio(negozio);

        int updated = articoloDAO.update(articolo);
        System.out.println("Numero di record aggiornati: " + updated);
    }
}
