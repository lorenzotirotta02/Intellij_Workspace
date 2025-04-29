package it.prova.gestioneordiniarticolicategorie.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private String codice;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
    private Set<Articolo> articoli = new HashSet<>();


    public void setArticoli(Set<Articolo> articoli) {
        this.articoli = articoli;
    }

    public Categoria() {
    }
    public Categoria(String descrizione, String codice) {
        this.descrizione = descrizione;
        this.codice = codice;
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

}
