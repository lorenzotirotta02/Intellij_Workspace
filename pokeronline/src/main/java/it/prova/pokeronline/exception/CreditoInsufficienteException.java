package it.prova.pokeronline.exception;

public class CreditoInsufficienteException extends RuntimeException {
    public CreditoInsufficienteException(String message) {
        super(message);
    }
}
