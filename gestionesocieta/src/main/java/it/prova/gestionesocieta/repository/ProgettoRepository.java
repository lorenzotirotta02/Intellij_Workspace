package it.prova.gestionesocieta.repository;


import it.prova.gestionesocieta.model.Progetto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgettoRepository extends JpaRepository<Progetto, Long> {

    @EntityGraph(attributePaths = { "dipendenti" })
    List<Progetto> findAllByDipendenti_RedditoAnnuoLordoGreaterThanEqual(int redditoAnnuoLordo);


    @Query(value = """
                SELECT p.*
                FROM progetto p
                JOIN dipendente_progetto dp ON p.id = dp.progetto_id
                JOIN dipendente d ON d.id = dp.dipendente_id
                JOIN societa s ON d.societa_id = s.id
                WHERE s.dataChiusura < CURRENT_DATE
            """, nativeQuery = true)
    List<Progetto> findAllByDipendentiWhereSocietaChiusa();
}
