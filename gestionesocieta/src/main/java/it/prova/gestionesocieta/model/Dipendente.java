package it.prova.gestionesocieta.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/// Dipendente (id, nome, cognome, dataAssunzione, reditoAnnuoLordo, società [null false])
@Entity
@Table(name = "dipendente")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataAssunzione;
    private int redditoAnnuoLordo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", nullable = false)
    private Societa societa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dipendente_progetto",
            joinColumns = @JoinColumn(name = "dipendente_id",  referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "progetto_id", referencedColumnName = "ID"))
    private Set<Progetto> progetti = new HashSet<>();

    public Dipendente(){

    }
    public Dipendente(String nome, String cognome, LocalDate dataAssunzione, int redditoAnnuoLordo) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.redditoAnnuoLordo = redditoAnnuoLordo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRedditoAnnuoLordo() {
        return redditoAnnuoLordo;
    }

    public void setRedditoAnnuoLordo(int redditoAnnuoLordo) {
        this.redditoAnnuoLordo = redditoAnnuoLordo;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public Set<Progetto> getProgetti() {
        return progetti;
    }

    public void setProgetti(Set<Progetto> progetti) {
        this.progetti = progetti;
    }

    public Societa getSocieta() {
        return societa;
    }

    public void setSocieta(Societa societa) {
        this.societa = societa;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "redditoAnnuoLordo=" + redditoAnnuoLordo +
                ", dataAssunzione=" + dataAssunzione +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
