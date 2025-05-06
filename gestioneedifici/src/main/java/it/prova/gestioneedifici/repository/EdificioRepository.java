package it.prova.gestioneedifici.repository;

import it.prova.gestioneedifici.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
