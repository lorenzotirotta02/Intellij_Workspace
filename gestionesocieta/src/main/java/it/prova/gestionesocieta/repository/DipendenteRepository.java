package it.prova.gestionesocieta.repository;

import it.prova.gestionesocieta.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {

    Dipendente findFirstByDataAssunzioneBeforeAndProgetti_DurataInMesiGreaterThanEqual(LocalDate dataFondazione, int durataInMesi);

}
