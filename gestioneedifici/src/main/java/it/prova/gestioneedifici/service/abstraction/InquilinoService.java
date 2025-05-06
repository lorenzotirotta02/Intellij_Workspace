package it.prova.gestioneedifici.service.abstraction;

import it.prova.gestioneedifici.model.Inquilino;

public interface InquilinoService {
    void inserisciInquilino(Inquilino inquilino, Long idEdificio);
}
