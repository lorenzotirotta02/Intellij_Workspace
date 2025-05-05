package it.prova.gestionesocieta.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

///(id, ragioneSociale, indirizzo, dataFondazione, dataChiusura)
@Entity
@Table(name = "societa")
public class Societa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ragioneSociale;
    private String indirizzo;
    private LocalDate dataFondazione;
    private LocalDate dataChiusura;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "societa")
    private List<Dipendente> dipendenti = new ArrayList<>();

    public Societa() {
    }
    public Societa(String ragioneSociale, String indirizzo, LocalDate dataFondazione, LocalDate dataChiusura) {
        super();
        this.ragioneSociale = ragioneSociale;
        this.indirizzo = indirizzo;
        this.dataFondazione = dataFondazione;
        this.dataChiusura = dataChiusura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDate getDataFondazione() {
        return dataFondazione;
    }

    public void setDataFondazione(LocalDate dataFondazione) {
        this.dataFondazione = dataFondazione;
    }

    public LocalDate getDataChiusura() {
        return dataChiusura;
    }

    public void setDataChiusura(LocalDate dataChiusura) {
        this.dataChiusura = dataChiusura;
    }

    @Override
    public String toString() {
        return "Societa{" +
                "id=" + id +
                ", ragioneSociale='" + ragioneSociale + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataFondazione=" + dataFondazione +
                ", dataChiusura=" + dataChiusura +
                '}';
    }
}
