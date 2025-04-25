package it.prova.atletasport.validator;

import it.prova.atletasport.exceptions.AtletaNotFoundException;
import it.prova.atletasport.exceptions.SportNotFoundException;
import it.prova.atletasport.model.Atleta;
import it.prova.atletasport.model.Sport;

public class ValidateSportAndAtleta {

    public static void validateSportAndAtleta(Sport sportInstance, Atleta atletaEsistente) throws Exception {
        if (sportInstance == null) {
            throw new SportNotFoundException("Sport non trovato");
        }
        if (atletaEsistente == null) {
            throw new AtletaNotFoundException("Atleta non trovato");
        }
    }
    public static void validateSportAndAtleta(Long idSport, Long idAtleta){
        if (idSport == null || idSport < 1) {
            throw new SportNotFoundException(idSport);
        }
        if (idAtleta == null || idAtleta < 1) {
            throw new AtletaNotFoundException(idAtleta);
        }
    }
    public static void validateSport(Long id){
        if (id == null || id < 1) {
            throw new SportNotFoundException(id);
        }
    }
    public static void validateAtleta(Long id){
        if (id == null || id < 1) {
            throw new AtletaNotFoundException(id);
        }
    }

}
