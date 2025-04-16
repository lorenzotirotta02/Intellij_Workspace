package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;
import it.prova.primoonetomany.model.Articolo;

import java.util.List;

public class TestFindAllByIndirizzoNegozio {
    public static void main(String[] args) {
        ArticoloDAO articoloDAO = new ArticoloDAO();

        String indirizzoCercato = "Corso Italia 33, Torino";

        List<Articolo> articoli = articoloDAO.findAllByIndirizzoNegozio(indirizzoCercato);

        System.out.println("Articoli trovati per indirizzo " + indirizzoCercato + ":");
        for (Articolo a : articoli) {
            System.out.println("ID: " + a.getId());
            System.out.println("Nome articolo: " + a.getNome());
            System.out.println("Matricola: " + a.getMatricola());
            System.out.println("Negozio: " + a.getNegozio().getNome() + " - " + a.getNegozio().getIndirizzo());
            System.out.println("Data Apertura: " + a.getNegozio().getDataApertura());

        }
    }
}

