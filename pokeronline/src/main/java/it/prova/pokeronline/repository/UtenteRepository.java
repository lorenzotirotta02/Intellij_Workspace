package it.prova.pokeronline.repository;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    @Query("select u.tavolo from Utente u where u.id = ?1 and u.tavolo is not null")
    Optional<Tavolo> findLastGameByUtenteId(Long idUtente);

    @Query("select u.tavolo from Utente u where u.esperienzaAccumulata >= u.tavolo.esperienzaMin and u.id = ?1")
    List<Tavolo> findTavoliCompatibilePerUtente(Long idUtente);

}
