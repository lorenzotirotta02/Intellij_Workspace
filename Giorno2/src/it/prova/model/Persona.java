package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean ePiuAnzianoDi(Persona altraPersona){
        return this.eta > altraPersona.getEta();
    }


}
