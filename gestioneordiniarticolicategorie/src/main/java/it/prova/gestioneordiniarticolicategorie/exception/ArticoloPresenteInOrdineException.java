package it.prova.gestioneordiniarticolicategorie.exception;

public class ArticoloPresenteInOrdineException extends RuntimeException{

    public ArticoloPresenteInOrdineException() {
        super("L'ordine ha degli articoli!");
    }

}
