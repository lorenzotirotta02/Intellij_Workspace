package it.prova.atletasport.exceptions;

public class AtletaNotFoundException extends RuntimeException{

    public AtletaNotFoundException(Long idAtleta) {
        super("Atleta con ID " + idAtleta + " non trovato.");
    }
    public AtletaNotFoundException(String message) {
        super(message);
    }
}
