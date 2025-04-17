package it.prova.model;

import java.time.LocalDate;

public class Televisore {
    private Long id;
    private String marca;
    private String modello;
    private int pollici;
    private LocalDate dataproduzione;

    public Televisore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getPollici() {
        return pollici;
    }

    public void setPollici(int pollici) {
        this.pollici = pollici;
    }

    public LocalDate getDataproduzione() {
        return dataproduzione;
    }

    public void setDataproduzione(LocalDate dataproduzione) {
        this.dataproduzione = dataproduzione;
    }
}
