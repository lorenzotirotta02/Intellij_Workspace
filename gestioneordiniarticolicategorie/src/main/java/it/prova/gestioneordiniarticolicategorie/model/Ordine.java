package it.prova.gestioneordiniarticolicategorie.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDestinatario;
    private String indirizzoDestinatario;
    @CreationTimestamp
    private LocalDateTime dataSpedizione;
    private LocalDateTime dataScadenza;

    @OneToMany(mappedBy = "ordine")
    private List<Articolo> articoli = new ArrayList<>();

    public List<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(List<Articolo> articoli) {
        this.articoli = articoli;
    }

    public Ordine() {
    }
    public Ordine(String nomeDestinatario, String indirizzoDestinatario, LocalDateTime dataSpedizione, LocalDateTime dataScadenza) {
        this.nomeDestinatario = nomeDestinatario;
        this.indirizzoDestinatario = indirizzoDestinatario;
        this.dataSpedizione = dataSpedizione;
        this.dataScadenza = dataScadenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getIndirizzoDestinatario() {
        return indirizzoDestinatario;
    }

    public void setIndirizzoDestinatario(String indirizzoDestinatario) {
        this.indirizzoDestinatario = indirizzoDestinatario;
    }

    public LocalDateTime getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(LocalDateTime dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDateTime dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

}
