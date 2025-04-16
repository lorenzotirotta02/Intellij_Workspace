package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.NegozioDAO;

public class TestDeleteNegozio {
        public static void main(String[] args) {
            Long idDaEliminare = 1L;

            NegozioDAO negozioDAO = new NegozioDAO();

            int righeEliminate = negozioDAO.delete(idDaEliminare);

            System.out.println("Numero di negozi eliminati: " + righeEliminate);
        }
    }

