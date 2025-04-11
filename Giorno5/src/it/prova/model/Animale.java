package it.prova.model;

public class Animale {
    protected String colore;
    protected String verso;

    public Animale(){}

    public Animale(String colore, String verso) {
        this.colore = colore;
        this.verso = verso;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getVerso() {
        return verso;
    }

    public void setVerso(String verso) {
        this.verso = verso;
    }
    public String versoCheFaIlMioAnimale(){
        return "Il mio animale " + this.verso;
    }
}
