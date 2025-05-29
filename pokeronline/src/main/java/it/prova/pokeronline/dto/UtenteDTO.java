package it.prova.pokeronline.dto;

import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Stato;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UtenteDTO {

    private Long id;

    @NotBlank(message = "{nome.notblank}")
    private String nome;
    @NotBlank(message = "{cognome.notblank}")
    private String cognome;
    @NotBlank(message = "{username.notblank}")
    private String username;

    private String password;

    private LocalDate dataRegistrazione;

    private Integer esperienzaAccumulata;

    private Double creditoAccumulato;

    private Stato stato;

    private Ruolo ruolo;

    public UtenteDTO() {
    }

    public UtenteDTO(Long id, String nome, String cognome, String username, String password, LocalDate dataRegistrazione, Integer esperienzaAccumulata, Double creditoAccumulato, Stato stato, Ruolo ruolo) {
        this.id = id;
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

    public UtenteDTO(Long id, String nome,
                     String cognome, String username,
                     Integer esperienzaAccumulata, Double creditoAccumulato, Stato stato, Ruolo ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.creditoAccumulato = creditoAccumulato;
        this.esperienzaAccumulata = esperienzaAccumulata;
        this.stato = stato;
        this.ruolo = ruolo;
    }

    public UtenteDTO(Long id, String nome, String cognome, String username, String password, Double creditoAccumulato){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.creditoAccumulato = creditoAccumulato;
    }

    public UtenteDTO(String nome, String cognome, String username, Integer esperienzaAccumulata, Double creditoAccumulato,
                     Stato stato, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.esperienzaAccumulata = esperienzaAccumulata;
        this.creditoAccumulato = creditoAccumulato;
        this.stato = stato;
        this.ruolo = ruolo;
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

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
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

    public Utente buildUtenteModel() {
        return new Utente(
                this.id,
                this.nome,
                this.cognome,
                this.username,
                this.esperienzaAccumulata,
                this.creditoAccumulato,
                this.stato,
                this.ruolo
        );
    }

    public Utente buildUtenteModelForUpdate(){
        return new Utente(
                this.id,
                this.nome,
                this.cognome,
                this.username,
                this.password,
                this.dataRegistrazione,
                this.esperienzaAccumulata,
                this.creditoAccumulato,
                this.stato,
                this.ruolo
        );
    }
    public static UtenteDTO buildUtenteDTOFromModelForUpdate(Utente utenteModel) {
        return new UtenteDTO(
                utenteModel.getId(),
                utenteModel.getNome(),
                utenteModel.getCognome(),
                utenteModel.getUsername(),
                utenteModel.getPassword(),
                utenteModel.getDataRegistrazione(),
                utenteModel.getEsperienzaAccumulata(),
                utenteModel.getCreditoAccumulato(),
                utenteModel.getStato(),
                utenteModel.getRuolo()
        );
    }
    //this.nome = nome;
    //        this.cognome = cognome;
    //        this.username = username;
    //        this.creditoAccumulato = creditoAccumulato;
    //        this.esperienzaAccumulata = esperienzaAccumulata;
    public static UtenteDTO buildUtenteDTOFromModel(Utente utenteModel) {
        return new UtenteDTO(
                utenteModel.getId(),
                utenteModel.getNome(),
                utenteModel.getCognome(),
                utenteModel.getUsername(),
                utenteModel.getEsperienzaAccumulata(),
                utenteModel.getCreditoAccumulato(),
                utenteModel.getStato(),
                utenteModel.getRuolo());
    }

    public Utente buildUtenteModelInsert(){
        return new Utente(this.id, this.nome, this.cognome, this.username,this.password,this.creditoAccumulato);
    }
    public static UtenteDTO buildUtenteDTOFromModelInsert(Utente utenteModel){
        return new UtenteDTO(utenteModel.getId(), utenteModel.getNome(), utenteModel.getCognome(),
                utenteModel.getUsername(),utenteModel.getPassword(),utenteModel.getCreditoAccumulato());
    }

}

