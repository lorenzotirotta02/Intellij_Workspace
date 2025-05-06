package it.prova.gestioneedifici.repository;

import it.prova.gestioneedifici.model.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
