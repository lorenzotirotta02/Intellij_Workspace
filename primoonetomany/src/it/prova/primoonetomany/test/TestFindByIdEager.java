package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;
import it.prova.primoonetomany.model.Negozio;

public class TestFindByIdEager {
    public static void main(String[] args) {
        ArticoloDAO articoloDAO = new ArticoloDAO();

        Long idDaCercare = 1L;

        Articolo articolo = articoloDAO.findByIdEager(idDaCercare);

        if (articolo != null) {
            System.out.println("Articolo trovato:");
            System.out.println("ID: " + articolo.getId());
            System.out.println("Nome: " + articolo.getNome());
            System.out.println("Matricola: " + articolo.getMatricola());

            Negozio negozio = articolo.getNegozio();
            System.out.println("Negozio associato:");
            System.out.println("ID: " + negozio.getId());
            System.out.println("Nome: " + negozio.getNome());
            System.out.println("Indirizzo: " + negozio.getIndirizzo());
            System.out.println("Data Apertura: " + negozio.getDataApertura());
        } else {
            System.out.println("Nessun articolo trovato con ID: " + idDaCercare);
        }
    }
}
