package it.prova.model;

public class Lavoratore {
    protected String nome;
    protected String cognome;

    public Lavoratore() {
    }

    public Lavoratore(String nome, String cognome) {
        this.nome = ("Paolo");
        this.cognome = ("Rossi");
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
    public String percepisco(){
        return "N.D.";
    }
}
