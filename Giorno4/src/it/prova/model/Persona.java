package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    private Indirizzo indirizzo;

    public Persona(String nome,  String cognome, int eta, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
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

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public boolean haAlmenoUnConcittadino(Persona[] elenco){
        for(int i = 0; i < elenco.length; i++) {
            if (this.indirizzo.getCitta().equals(elenco[i].getIndirizzo().getCitta())) {
                return true;
            }
        }
        return false;
    }
    public boolean abitaA(String cittaInput){
        return this.indirizzo.getCitta().equals(cittaInput);
    }
    public boolean sonoTuttiPiuAnziani(Persona[] elenco){
        for(int i = 0; i < elenco.length; i++){
            if(this.eta > elenco[i].getEta()){
                return false;
            }
        }
        return true;
    }
    public int quantiCoabitanoNelMioStessoPalazzo(Persona[] elencoInput){
        int count = 0;
        for(int i = 0; i < elencoInput.length; i++){
            if(this.indirizzo.equals(elencoInput[i].getIndirizzo())){
                count += 1;
            }
        }
        return count;
    }
}
