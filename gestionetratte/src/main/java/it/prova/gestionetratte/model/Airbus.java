package it.prova.gestionetratte.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "airbus")
public class Airbus {
    //Airbus (id, codice, descrizione, dataInizioServizio, numeroPasseggeri, tratte)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;

    private String descrizione;

    private LocalDate dataInizioServizio;

    private Integer numeroPasseggeri;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airbus")
    private Set<Tratta> tratte = new HashSet<Tratta>(0);

    public Airbus() {
    }

    public Airbus(Long id, String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPasseggeri) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.dataInizioServizio = dataInizioServizio;
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public Airbus(String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPasseggeri) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.dataInizioServizio = dataInizioServizio;
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataInizioServizio() {
        return dataInizioServizio;
    }

    public void setDataInizioServizio(LocalDate dataInizioServizio) {
        this.dataInizioServizio = dataInizioServizio;
    }

    public Integer getNumeroPasseggeri() {
        return numeroPasseggeri;
    }

    public void setNumeroPasseggeri(Integer numeroPasseggeri) {
        this.numeroPasseggeri = numeroPasseggeri;
    }

    public Set<Tratta> getTratte() {
        return tratte;
    }

    public void setTratte(Set<Tratta> tratte) {
        this.tratte = tratte;
    }
}
