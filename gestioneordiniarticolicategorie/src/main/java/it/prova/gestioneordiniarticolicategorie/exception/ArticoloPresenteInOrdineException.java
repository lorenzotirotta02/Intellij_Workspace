package it.prova.gestioneordiniarticolicategorie.exception;

public class ArticoloPresenteInOrdineException extends RuntimeException{

    public ArticoloPresenteInOrdineException() {
        super("L'articolo è presente in un ordine");
    }

}
