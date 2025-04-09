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
    public boolean almenoUnoHaLaMediaMiglioreDellaMia(Studente[] corso){
        int count = 0;
        for(int i = 0; i < corso.length; i++){
            if(this.mediaScolastica < corso[i].getMediaScolastica()){
                count += 1;
            }
        }
        return count == 1;
    }
    public int quantiOmonimiMinorenniHo(Studente[] corso){
        int count = 0;
        for(int i = 0; i < corso.length; i++){
            if(this.nome.equals(corso[i].getNome()) && corso[i].getEta() < 18){
                count += 1;
            }
        }
        return count;
    }
    public static int quanteMedieSopraLaSufficienza(Studente[] corso){
        int count = 0;
        for(int i = 0; i < corso.length; i++){
            if(corso[i].getMediaScolastica() < 6.0){
                count += 1;
            }
        }
        return count;
    }
}
