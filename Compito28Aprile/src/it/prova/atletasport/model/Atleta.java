package it.prova.atletasport.model;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/// Atleta (id, nome, cognome, dataDiNascita, codice, numeroMedaglieVinte)
///
///
@Entity
@Table(name = "atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String cognome;
    public LocalDate dataDiNascita;
    public String codice;
    public int numeroMedaglieVinte;

    @Enumerated(EnumType.STRING)
    private SportAtleta stato = SportAtleta.CALCIO;


    @ManyToMany
    @JoinTable(name = "atleta_sport", joinColumns = @JoinColumn(name = "atleta_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "ID"))
    private Set<Sport> sports = new HashSet<>(0);


    public Atleta() {
    }

    public Atleta(String nome, String cognome, LocalDate dataDiNascita, String codice, int numeroMedaglieVinte) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codice = codice;
        this.numeroMedaglieVinte = numeroMedaglieVinte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public SportAtleta getStato() {
        return stato;
    }

    public void setStato(SportAtleta stato) {
        this.stato = stato;
    }

    public int getNumeroMedaglieVinte() {
        return numeroMedaglieVinte;
    }

    public void setNumeroMedaglieVinte(int numeroMedaglieVinte) {
        this.numeroMedaglieVinte = numeroMedaglieVinte;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
