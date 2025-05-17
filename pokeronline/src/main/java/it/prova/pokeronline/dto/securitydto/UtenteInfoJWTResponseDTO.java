package it.prova.pokeronline.dto.securitydto;


import it.prova.pokeronline.model.Ruolo;

public class UtenteInfoJWTResponseDTO {
    private String nome;
    private String cognome;
    private String type = "Bearer";
    private String username;
    private String email;
    private Ruolo ruolo;

    public UtenteInfoJWTResponseDTO(String nome, String cognome, String username, String email, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.ruolo = ruolo;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo){
        this.ruolo = ruolo;
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
}
