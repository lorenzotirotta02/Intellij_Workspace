package it.prova.model;

public class Programmatore {
    private String nome;
    private String cognome;
    private int eta;
    private String linguaggio;

    private Ufficio ufficio;

    public Programmatore(String nome, String cognome, int eta, String linguaggio, Ufficio ufficio) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.linguaggio = linguaggio;
        this.ufficio = ufficio;
    }


    public Ufficio getUfficio() {
        return ufficio;
    }

    public String getNome() {
        return nome;
    }

    public String getLinguaggio() {
        return linguaggio;
    }

    public int getEta() {
        return eta;
    }

    public String getCognome() {
        return cognome;
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

    public void setLinguaggio(String linguaggio) {
        this.linguaggio = linguaggio;
    }

    public void setUfficio(Ufficio ufficio) {
        this.ufficio = ufficio;
    }
    public int quantiProgrammatoriNelMioUfficio(Programmatore[] lista){
        int count = 0;
        for(int i = 0; i < lista.length; i++){
            if(this.ufficio.getNome().equals(lista[i].getUfficio().getNome()) &&
            this.ufficio.getVia().equals(lista[i].getUfficio().getVia())){
                count += 1;
            }
        }
        return count;
    }
}
