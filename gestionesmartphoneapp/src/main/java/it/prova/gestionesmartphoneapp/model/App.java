package it.prova.gestionesmartphoneapp.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    @CreationTimestamp
    public LocalDate dataInstallazione;
    @UpdateTimestamp
    public LocalDate dataUltimoAggiornamento;
    public String versione;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "apps")
    private Set<Smartphone> smartphone = new HashSet<>();

    public App() {
    }

    public App(String nome, LocalDate dataInstallazione, LocalDate dataUltimoAggiornamento, String versione) {
        this.nome = nome;
        this.dataInstallazione = dataInstallazione;
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
        this.versione = versione;
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

    public LocalDate getDataInstallazione() {
        return dataInstallazione;
    }

    public void setDataInstallazione(LocalDate dataInstallazione) {
        this.dataInstallazione = dataInstallazione;
    }

    public LocalDate getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    public void setDataUltimoAggiornamento(LocalDate dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    public String getVersione() {
        return versione;
    }

    public void setVersione(String versione) {
        this.versione = versione;
    }

    public Set<Smartphone> getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Set<Smartphone> smartphone) {
        this.smartphone = smartphone;
    }
}
