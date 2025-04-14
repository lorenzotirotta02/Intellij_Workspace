package it.prova.model;

import java.util.ArrayList;

public class Hotel {
    private String ragioneSociale;
    private int stelle;

    private ArrayList<Stanza> stanze;

    public Hotel(String ragioneSociale, int stelle) {
        this.ragioneSociale = ragioneSociale;
        this.stelle = stelle;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public void setStanze(ArrayList<Stanza> stanze) {
        this.stanze = stanze;
    }

    public double calcolaConto(Stanza input){
        for(Stanza stanza : stanze){
            if(stanza.getNumeroStanza() != input.getNumeroStanza()){
                return 0;
            }
        }
        double risultato = 0;
        for(Cliente cliente : input.getClienti()){
            risultato += cliente.sommaDaPagare();
        }
        return risultato;
    }
}