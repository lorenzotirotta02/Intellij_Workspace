package it.prova.primoonetomany.test;

import it.prova.primoonetomany.dao.ArticoloDAO;

public class TestDeleteArticolo {
    public static void main(String[] args) {
        ArticoloDAO dao = new ArticoloDAO();

        Long idArticoloDaEliminare = 2L; // Sostituisci con un ID valido

        int risultato = dao.delete(idArticoloDaEliminare);

        if (risultato > 0) {
            System.out.println("Articolo con ID " + idArticoloDaEliminare + " eliminato con successo.");
        } else {
            System.out.println("Articolo non trovato o eliminazione non riuscita.");
        }
    }
}
