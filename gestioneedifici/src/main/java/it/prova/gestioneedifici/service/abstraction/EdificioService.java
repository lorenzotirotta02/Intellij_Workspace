package it.prova.gestioneedifici.service.abstraction;

import it.prova.gestioneedifici.model.Edificio;

import java.util.Map;

public interface EdificioService {
    void inserimentoEdificio(Edificio edificio);
    Map<Edificio, Integer> ottieniMappaInversa(Long id);
}
