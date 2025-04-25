package it.prova.atletasport.exceptions;

public class SportNotFoundException extends RuntimeException{

    public SportNotFoundException(Long idSport) {
        super("Sport con ID " + idSport + " non trovato.");
    }
    public SportNotFoundException(String message) {
        super(message);
    }
}
