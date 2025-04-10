package it.prova.model;

public class Biglietto {
    private String nomeSpettacolo;
    private char letteraFila;
    private String numeroPosto;
    private int prezzo;

    public Biglietto(String nomeSpettacolo, char letteraFila, String numeroPosto, int prezzo) {
        this.nomeSpettacolo = nomeSpettacolo;
        this.letteraFila = letteraFila;
        this.numeroPosto = numeroPosto;
        this.prezzo = prezzo;
    }

    public String getNomeSpettacolo() {
        return nomeSpettacolo;
    }

    public char getLetteraFila() {
        return letteraFila;
    }

    public String getNumeroPosto() {
        return numeroPosto;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setNomeSpettacolo(String nomeSpettacolo) {
        this.nomeSpettacolo = nomeSpettacolo;
    }

    public void setLetteraFila(char letteraFila) {
        this.letteraFila = letteraFila;
    }

    public void setNumeroPosto(String numeroPosto) {
        this.numeroPosto = numeroPosto;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
}
