package it.prova.gestionesmartphoneapp.model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public LocalDateTime dataInstallazione;
    @UpdateTimestamp
    public LocalDateTime dataUltimoAggiornamento;
    public String versione;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "apps")
    private Set<Smartphone> smartphone = new HashSet<>();

    public App() {
    }

    public App(String nome, LocalDateTime dataInstallazione, LocalDateTime dataUltimoAggiornamento, String versione) {
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

    public LocalDateTime getDataInstallazione() {
        return dataInstallazione;
    }

    public void setDataInstallazione(LocalDateTime dataInstallazione) {
        this.dataInstallazione = dataInstallazione;
    }

    public LocalDateTime getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    public void setDataUltimoAggiornamento(LocalDateTime dataUltimoAggiornamento) {
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
