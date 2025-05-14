package it.prova.gestionetratte.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tratta")
public class Tratta {
    //(id, codice, descrizione, data, oraDecollo, oraAtterraggio,
    // stato=ATTIVA, CONCLUSA, ANNULLATA, airbus)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;

    private String descrizione;

    private LocalDate data;

    private LocalTime oraDecollo;

    private LocalTime oraAtterraggio;

    @Enumerated(EnumType.STRING)
    private StatoTratta statoTratta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airbus_id", nullable = false)
    private Airbus airbus;

    public Tratta() {
    }

    public Tratta(String codice, String descrizione, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio,
                  StatoTratta statoTratta) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.data = data;
        this.oraDecollo = oraDecollo;
        this.oraAtterraggio = oraAtterraggio;
        this.statoTratta = statoTratta;
    }

    public Tratta(Long id, String codice, String descrizione, LocalDate data, LocalTime oraDecollo,
                  LocalTime oraAtterraggio, StatoTratta statoTratta) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.data = data;
        this.oraDecollo = oraDecollo;
        this.oraAtterraggio = oraAtterraggio;
        this.statoTratta = statoTratta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOraDecollo() {
        return oraDecollo;
    }

    public void setOraDecollo(LocalTime oraDecollo) {
        this.oraDecollo = oraDecollo;
    }

    public LocalTime getOraAtterraggio() {
        return oraAtterraggio;
    }

    public void setOraAtterraggio(LocalTime oraAtterraggio) {
        this.oraAtterraggio = oraAtterraggio;
    }

    public StatoTratta getStatoTratta() {
        return statoTratta;
    }

    public void setStatoTratta(StatoTratta statoTratta) {
        this.statoTratta = statoTratta;
    }

    public Airbus getAirbus() {
        return airbus;
    }

    public void setAirbus(Airbus airbus) {
        this.airbus = airbus;
    }

}
