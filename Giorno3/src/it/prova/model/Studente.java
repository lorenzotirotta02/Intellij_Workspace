package it.prova.model;

public class Studente {
    private String nome;
    private String cognome;
    private int eta;
    private double mediaScolastica;

    public Studente(String nome, String cognome, int eta, double mediaScolastica) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.mediaScolastica = mediaScolastica;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public double getMediaScolastica() {
        return mediaScolastica;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setMediaScolastica(double mediaScolastica) {
        this.mediaScolastica = mediaScolastica;
    }

    public boolean sonoTuttiPiuGiovaniDiMe(Studente[] corso){
        for(int i = 0; i < corso.length; i++){
            if(this.eta > corso[i].getEta()){
                return false;
            }
        }
        return true;
    }
}
