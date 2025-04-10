package it.prova.model;

public class Ufficio {
    private String nome;
    private double distanza;
    private String via;
    private String citta;

    public Ufficio(String nome, String via, double distanza, String citta) {
        this.nome = nome;
        this.via = via;
        this.distanza = distanza;
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public double getDistanza() {
        return distanza;
    }

    public String getVia() {
        return via;
    }
    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDistanza(double distanza) {
        this.distanza = distanza;
    }

    public void setVia(String via) {
        this.via = via;
    }
}
