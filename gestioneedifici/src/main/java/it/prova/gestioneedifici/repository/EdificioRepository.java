package it.prova.gestioneedifici.repository;

import it.prova.gestioneedifici.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    @Query("SELECT new map(COUNT(i) as value, e as key) FROM Edificio e LEFT JOIN e.inquilini i WHERE e.id = :id GROUP BY e")
    List<Map<String, Object>> findEdificioWithCountInquilini(@Param("id") Long id);

    default Map<Edificio, Integer> ottieniMappaInversa(Long id) {
        return findEdificioWithCountInquilini(id).stream()
                .collect(Collectors.toMap(
                        m -> (Edificio) m.get("key"),
                        m -> ((Number) m.get("value")).intValue()
                ));
    }




}
