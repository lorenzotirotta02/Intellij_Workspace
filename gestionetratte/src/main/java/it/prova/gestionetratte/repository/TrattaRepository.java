package it.prova.gestionetratte.repository;

import it.prova.gestionetratte.model.StatoTratta;
import it.prova.gestionetratte.model.Tratta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TrattaRepository extends JpaRepository<Tratta, Long> {

    @Query("from Tratta t join fetch t.airbus where t.id = ?1")
    Tratta findSingleTrattaEager(Long id);


    @Query("select t from Tratta t join fetch t.airbus")
    List<Tratta> findAllTratteEager();

    @Query("select t from Tratta t where t.statoTratta = :stato and FUNCTION('TIMESTAMP', t.data, t.oraAtterraggio) < CURRENT_TIMESTAMP")
    List<Tratta> findTratteDaConcludere(@Param("stato") StatoTratta stato);
}
