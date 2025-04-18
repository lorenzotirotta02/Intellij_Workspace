package it.prova.proprietarioautomobile.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proprietario")
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String cf;
    private LocalDate dataDiNascita;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
    private Set<Automobile> automobili = new HashSet<>();

    public Proprietario() {
    }
    public Proprietario(String nome, String cognome, String cf, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dataDiNascita = dataDiNascita;
    }

    public Set<Automobile> getAutomobili() {
        return automobili;
    }

    public void setAutomobili(Set<Automobile> automobili) {
        this.automobili = automobili;
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

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
