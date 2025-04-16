package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;
import it.prova.primoonetomany.model.Negozio;

import java.util.List;

public class TestFindAllByIniziali {
    public static void main(String[] args) {
        NegozioDAO negozioDao = new NegozioDAO();

        String iniziali = "Bi";

        List<Negozio> listaNegozi = negozioDao.findAllByIniziali(iniziali);

        if (listaNegozi.isEmpty()) {
            System.out.println("Nessun negozio trovato che inizia con: " + iniziali);
        } else {
            System.out.println("Negozi trovati con iniziali '" + iniziali + "':");
            for (Negozio n : listaNegozi) {
                System.out.println("ID: " + n.getId());
                System.out.println("Nome: " + n.getNome());
                System.out.println("Indirizzo: " + n.getIndirizzo());
                System.out.println("Data Apertura: " + n.getDataApertura());
                System.out.println("....................");
            }
        }
    }
}
