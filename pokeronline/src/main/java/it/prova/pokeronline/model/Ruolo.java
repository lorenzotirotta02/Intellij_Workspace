package it.prova.pokeronline.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ruolo")
public class Ruolo {


    public static final String ADMIN = "ADMIN";
    public static final String NPLAYER = "PLAYER";
    public static final String SPECIAL_PLAYER = "SPECIAL_PLAYER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private String codice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ruolo")
    @JsonIgnoreProperties({"ruolo", "tavolo"})
    private Set<Utente> utenti = new HashSet<Utente>(0);

    public Ruolo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "Ruolo{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", codice='" + codice + '\'' +
                '}';
    }
}
