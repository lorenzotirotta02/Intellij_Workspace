package it.prova.gestioneordiniarticolicategorie.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Articolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private String numeroSeriale;
    private double prezzoSingolo;
    @CreationTimestamp
    private LocalDateTime dataInserimento;

    @ManyToOne
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;


    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
    private Set<Categoria> categorie = new HashSet<>();



    public Articolo() {
    }
    public Articolo(String descrizione, String numeroSeriale, double prezzoSingolo, LocalDateTime dataInserimento) {
        this.descrizione = descrizione;
        this.numeroSeriale = numeroSeriale;
        this.prezzoSingolo = prezzoSingolo;
        this.dataInserimento = dataInserimento;
    }

    public Set<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(Set<Categoria> categorie) {
        this.categorie = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public LocalDateTime getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDateTime dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public double getPrezzoSingolo() {
        return prezzoSingolo;
    }

    public void setPrezzoSingolo(double prezzoSingolo) {
        this.prezzoSingolo = prezzoSingolo;
    }

    public String getNumeroSeriale() {
        return numeroSeriale;
    }

    public void setNumeroSeriale(String numeroSeriale) {
        this.numeroSeriale = numeroSeriale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
