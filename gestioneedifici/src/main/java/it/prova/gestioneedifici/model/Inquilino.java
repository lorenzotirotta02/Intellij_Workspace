package it.prova.gestioneedifici.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inquilino")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private Long affittoDovuto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Inquilino() {
    }
    public Inquilino(String nome, String cognome, LocalDate dataNascita, Long affittoDovuto) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.affittoDovuto = affittoDovuto;
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

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Long getAffittoDovuto() {
        return affittoDovuto;
    }

    public void setAffittoDovuto(Long affittoDovuto) {
        this.affittoDovuto = affittoDovuto;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        return "Inquilino{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", affittoDovuto=" + affittoDovuto +
                ", edificio=" + edificio +
                '}';
    }
}
