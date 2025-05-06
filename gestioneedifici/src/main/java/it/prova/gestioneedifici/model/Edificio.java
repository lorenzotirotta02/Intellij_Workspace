package it.prova.gestioneedifici.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String indirizzo;
    private String dittaProprietaria;
    private LocalDate dataCostruzione;
    private int numeroPiani;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "edificio")
    private List<Inquilino> inquilini = new ArrayList<>();

    public Edificio() {
    }
    public Edificio(String indirizzo, String dittaProprietaria, LocalDate dataCostruzione, int numeroPiani) {
        this.indirizzo = indirizzo;
        this.dittaProprietaria = dittaProprietaria;
        this.dataCostruzione = dataCostruzione;
        this.numeroPiani = numeroPiani;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPiani() {
        return numeroPiani;
    }

    public void setNumeroPiani(int numeroPiani) {
        this.numeroPiani = numeroPiani;
    }

    public List<Inquilino> getInquilini() {
        return inquilini;
    }

    public void setInquilini(List<Inquilino> inquilini) {
        this.inquilini = inquilini;
    }

    public LocalDate getDataCostruzione() {
        return dataCostruzione;
    }

    public void setDataCostruzione(LocalDate dataCostruzione) {
        this.dataCostruzione = dataCostruzione;
    }

    public String getDittaProprietaria() {
        return dittaProprietaria;
    }

    public void setDittaProprietaria(String dittaProprietaria) {
        this.dittaProprietaria = dittaProprietaria;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "numeroPiani=" + numeroPiani +
                ", dataCostruzione=" + dataCostruzione +
                ", dittaProprietaria='" + dittaProprietaria + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", id=" + id +
                '}';
    }
}
