package it.prova.pokeronline.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "utente")
public class Utente {
    //Utente (che è anche il giocatore) con i campi classici
    // (nome, cognome, username, password, data registrazione, stato, esperienzaAccumulata
    // (indica una specie di punteggio attribuito dal sistema per cercare di livellare le abilità dei
    // giocatori e far
    // quindi disputare partite alla pari), creditoAccumulato
    // (in pratica il credito accumulato in termini di soldi)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cognome;

    private String username;

    private String password;

    private LocalDate dataRegistrazione;

    private Integer esperienzaAccumulata;

    private Double creditoAccumulato;

    private Stato stato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruolo_id", nullable = false)
    @JsonIgnoreProperties("utenti")
    private Ruolo ruolo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;

    public Utente() {
    }

    public Utente(Long id,String nome, String cognome, String username, Integer esperienzaAccumulata,
                  Double creditoAccumulato, Stato stato, Ruolo ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.esperienzaAccumulata = esperienzaAccumulata;
        this.creditoAccumulato = creditoAccumulato;
        this.stato = stato;
        this.ruolo = ruolo;
    }

    public Utente(String nome, String cognome, String username, String password, LocalDate dataRegistrazione,
                  Integer esperienzaAccumulata, Double creditoAccumulato, Stato stato, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
        this.esperienzaAccumulata = esperienzaAccumulata;
        this.creditoAccumulato = creditoAccumulato;
        this.stato = stato;
        this.ruolo = ruolo;
    }
    public Utente(Long id, String nome, String cognome, String username, String password,
                  Double creditoAccumulato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.creditoAccumulato = creditoAccumulato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public Integer getEsperienzaAccumulata() {
        return esperienzaAccumulata;
    }

    public void setEsperienzaAccumulata(Integer esperienzaAccumulata) {
        this.esperienzaAccumulata = esperienzaAccumulata;
    }

    public Double getCreditoAccumulato() {
        return creditoAccumulato;
    }

    public void setCreditoAccumulato(Double creditoAccumulato) {
        this.creditoAccumulato = creditoAccumulato;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public boolean isDisabilitato() {
        return this.stato != null && this.stato.equals(Stato.DISABILITATO);
    }

    public boolean isAttivo() {
        return this.stato != null && this.stato.equals(Stato.ATTIVO) || this.stato.equals(Stato.CREATO);
    }

    public Tavolo getTavolo() {
        return tavolo;
    }
    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }
}
