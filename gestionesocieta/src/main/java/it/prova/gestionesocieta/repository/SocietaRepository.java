package it.prova.gestionesocieta.repository;


import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Societa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SocietaRepository extends JpaRepository<Societa, Long> {
    boolean existsByRagioneSociale(String ragioneSociale);

    @Query(value = "SELECT d.id, d.nome, d.cognome, d.dataAssunzione, d.redditoAnnuoLordo, d.societa_id FROM dipendente d WHERE d.societa_id = ?1", nativeQuery = true)
    List<Dipendente> findAllDipendentiBySocieta(Long societaId);

    @Query(value = "SELECT DISTINCT p.cliente FROM progetto p " +
            "JOIN dipendente_progetto dp ON p.id = dp.progetto_id " +
            "JOIN dipendente d ON d.id = dp.dipendente_id " +
            "WHERE d.societa_id = ?1", nativeQuery = true)
    List<String> findAllClientiBySocietaId(Long id);

    @Query(value = "SELECT DISTINCT s.ragioneSociale FROM societa s " +
            "JOIN dipendente d ON s.id = d.societa_id " +
            "JOIN dipendente_progetto dp ON d.id = dp.dipendente_id " +
            "JOIN progetto p ON p.id = dp.progetto_id " +
            "WHERE p.durataInMesi > 12", nativeQuery = true)
    List<String> findAllNomeSocietaWithProgettiDurataMaggioreDiUnAnno();

    @Query(value = "SELECT DISTINCT s FROM Societa s JOIN s.dipendenti d WHERE d.dataAssunzione < s.dataFondazione")
    List<Societa> findAllByDipendenti_DataAssunzioneBeforeAndDataFondazione();



}
