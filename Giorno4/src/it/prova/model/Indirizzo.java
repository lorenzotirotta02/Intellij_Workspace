package it.prova.model;

public class Indirizzo {
    private String citta;
    private String via;
    private String civico;

    public Indirizzo(String citta, String via, String civico) {
        this.citta = citta;
        this.civico = civico;
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public String getVia() {
        return via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

}
